import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalTurningPoint = Integer.parseInt(st.nextToken());
        int totalRoad = Integer.parseInt(st.nextToken());

        boolean[] canSee = new boolean[totalTurningPoint];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalTurningPoint; i++) {
            canSee[i] = (Integer.parseInt(st.nextToken()) == 1);
        }

        ArrayList<Road>[] roads = new ArrayList[totalTurningPoint];
        for (int i = 0; i < totalTurningPoint; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < totalRoad; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if ((canSee[a] && a != totalTurningPoint - 1) || (canSee[b] && b != totalTurningPoint - 1)) {
                continue;
            }

            roads[a].add(new Road(b, cost));
            roads[b].add(new Road(a, cost));
        }

        long[] maxCost = new long[totalTurningPoint];
        for (int i = 0; i < totalTurningPoint; i++) {
            maxCost[i] = Long.MAX_VALUE;
        }

        PriorityQueue<Place> places = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        places.add(new Place(0, 0));
        maxCost[0] = 0;

        while (!places.isEmpty()) {
            Place currentPlace = places.poll();

            if (maxCost[currentPlace.idx] < currentPlace.cost) {
                continue;
            }

            for (Road road : roads[currentPlace.idx]) {
                int nextPlace = road.destination;
                long nextCost = currentPlace.cost + road.cost;
                if (maxCost[nextPlace] <= nextCost) {
                    continue;
                }
                maxCost[nextPlace] = nextCost;
                places.add(new Place(nextPlace, nextCost));
            }
        }

        sb.append(maxCost[totalTurningPoint - 1] == Long.MAX_VALUE ? -1 : maxCost[totalTurningPoint - 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Place {
        int idx;
        long cost;

        Place(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static class Road {
        int destination;
        int cost;

        Road(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}