import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int buildingCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());
        long totalRoadCost = 0;
        int[] parent = new int[buildingCnt + 1];
        for (int idx = 1; idx <= buildingCnt; idx++) {
            parent[idx] = idx;
        }

        PriorityQueue<Road> roads = new PriorityQueue<>();
        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            roads.add(new Road(a, b, cost));
            totalRoadCost += cost;
        }

        long minRoadCost = 0;
        while (!roads.isEmpty()) {
            Road road = roads.poll();
            if (!isConnected(parent, road.getBuildingA(), road.getBuildingB())) {
                minRoadCost += road.getCost();
            }
        }

        boolean isAllConnected = true;
        int pa = find(parent, 1);
        for (int i = 1; i <= buildingCnt; i++) {
            if (pa != find(parent, i)) {
                isAllConnected = false;
            }
        }

        sb.append(isAllConnected ? totalRoadCost - minRoadCost : -1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int[] p, int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p, p[x]);
    }

    public static boolean isConnected(int[] p, int a, int b) {
        int pa = find(p, a);
        int pb = find(p, b);
        p[pa] = pb;
        return pa == pb;
    }
}

class Road implements Comparable {
    private int buildingA;
    private int buildingB;
    private long cost;

    Road(int buildingA, int buildingB, long cost) {
        this.buildingA = buildingA;
        this.buildingB = buildingB;
        this.cost = cost;
    }

    public int getBuildingA() {
        return this.buildingA;
    }

    public int getBuildingB() {
        return this.buildingB;
    }

    public long getCost() {
        return this.cost;
    }

    @Override
    public int compareTo(Object o) {
        Road r = (Road) o;
        return Long.compare(this.cost, r.getCost());
    }
}
