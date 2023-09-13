import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_COW = 1000;
    final static int START_BARN = 1;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int barnCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] roads = new ArrayList[barnCnt + 1];
        for (int i = 1; i <= barnCnt; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cowCnt = Integer.parseInt(st.nextToken());

            roads[a].add(new int[]{b, cowCnt});
            roads[b].add(new int[]{a, cowCnt});
        }

        int[] cost = new int[barnCnt + 1];
        for (int i = 1; i <= barnCnt; i++) {
            cost[i] = MAX_COW * barnCnt + 1;
        }
        cost[START_BARN] = 0;
        PriorityQueue<int[]> possibleBarns = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        possibleBarns.add(new int[]{0, START_BARN});
        while (!possibleBarns.isEmpty()) {
            int[] possibleBarn = possibleBarns.poll();
            int currentCost = possibleBarn[0];
            int current = possibleBarn[1];

            for (int[] road : roads[current]) {
                int next = road[0];
                int nextCost = road[1];
                int nextForCost = currentCost + nextCost;
                if (nextForCost < cost[next]) {
                    cost[next] = nextForCost;
                    possibleBarns.add(new int[]{nextForCost, next});
                }
            }
        }
        sb.append(cost[barnCnt]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
