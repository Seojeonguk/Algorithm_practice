import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cityCnt = Integer.parseInt(st.nextToken());
                int roadCnt = Integer.parseInt(st.nextToken());
                int destinationCnt = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                int startCity = Integer.parseInt(st.nextToken());
                int firstPassedCity = Integer.parseInt(st.nextToken());
                int secondPassedCity = Integer.parseInt(st.nextToken());

                ArrayList<int[]>[] roads = new ArrayList[cityCnt + 1];
                for (int cityNum = 1; cityNum <= cityCnt; cityNum++) {
                    roads[cityNum] = new ArrayList<>();
                }

                for (int i = 0; i < roadCnt; i++) {
                    StringTokenizer roadInfo = new StringTokenizer(br.readLine());
                    int aCity = Integer.parseInt(roadInfo.nextToken());
                    int bCity = Integer.parseInt(roadInfo.nextToken());
                    int cost = Integer.parseInt(roadInfo.nextToken());

                    roads[aCity].add(new int[]{bCity, cost});
                    roads[bCity].add(new int[]{aCity, cost});
                }

                int[] distanceFromStartCity = calDistanceFromCity(startCity, roads);
                int[] distanceFromFirstPassedCity = calDistanceFromCity(firstPassedCity, roads);
                int[] distanceFromSecondPassedCity = calDistanceFromCity(secondPassedCity, roads);

                PriorityQueue<Integer> destinations = new PriorityQueue<>();
                for (int i = 0; i < destinationCnt; i++) {
                    int destination = Integer.parseInt(br.readLine());

                    if (distanceFromStartCity[destination] == distanceFromStartCity[firstPassedCity] + distanceFromFirstPassedCity[secondPassedCity] + distanceFromSecondPassedCity[destination] ||
                            distanceFromStartCity[destination] == distanceFromStartCity[secondPassedCity] + distanceFromSecondPassedCity[firstPassedCity] + distanceFromFirstPassedCity[destination]) {
                        destinations.add(destination);
                    }
                }

                while (!destinations.isEmpty()) {
                    sb.append(destinations.poll()).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int[] calDistanceFromCity(int city, ArrayList<int[]>[] roads) {
        int[] distances = new int[roads.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[city] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        pq.add(new int[]{0, city});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curCity = cur[1];

            for (int[] nextCityInfo : roads[curCity]) {
                int nextCity = nextCityInfo[0];
                int nextCost = -curCost + nextCityInfo[1];

                if (distances[nextCity] > nextCost) {
                    distances[nextCity] = nextCost;
                    pq.add(new int[]{-nextCost, nextCity});
                }
            }
        }

        return distances;
    }
}
