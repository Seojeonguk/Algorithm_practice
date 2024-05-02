import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int maxMinCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int intersectionCnt = Integer.parseInt(st.nextToken());
            int pathCnt = Integer.parseInt(st.nextToken());
            int startIntersection = Integer.parseInt(st.nextToken());
            int destinationIntersection = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            ArrayList<int[]>[] paths = new ArrayList[intersectionCnt + 1];
            for (int i = 1; i <= intersectionCnt; i++) {
                paths[i] = new ArrayList<>();
            }

            for (int i = 0; i < pathCnt; i++) {
                StringTokenizer pathInfo = new StringTokenizer(br.readLine());
                int aPath = Integer.parseInt(pathInfo.nextToken());
                int bPath = Integer.parseInt(pathInfo.nextToken());
                int cost = Integer.parseInt(pathInfo.nextToken());

                paths[aPath].add(new int[]{bPath, cost});
                paths[bPath].add(new int[]{aPath, cost});
            }

            boolean[] visited = new boolean[intersectionCnt + 1];
            visited[startIntersection] = true;
            calMaxMinCost(paths, visited, startIntersection, destinationIntersection, money, 0);

            sb.append(maxMinCost == Integer.MAX_VALUE ? -1 : maxMinCost);

            bw.write(sb.toString());
        }
    }

    public static void calMaxMinCost(ArrayList<int[]>[] paths, boolean[] visited, int currentIntersection, int destinationIntersection, int availableMoney, int maxPathCost) {
        if (currentIntersection == destinationIntersection) {
            maxMinCost = Math.min(maxMinCost, maxPathCost);
        }

        for (int[] nextPath : paths[currentIntersection]) {
            if (visited[nextPath[0]] || availableMoney < nextPath[1]) {
                continue;
            }

            visited[nextPath[0]] = true;
            calMaxMinCost(paths, visited, nextPath[0], destinationIntersection, availableMoney - nextPath[1], Math.max(maxPathCost, nextPath[1]));
            visited[nextPath[0]] = false;
        }
    }
}
