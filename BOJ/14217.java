import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityCnt = Integer.parseInt(st.nextToken());
            int roadCnt = Integer.parseInt(st.nextToken());

            HashSet<Integer>[] roads = new HashSet[cityCnt];
            for (int cityNum = 0; cityNum < cityCnt; cityNum++) {
                roads[cityNum] = new HashSet<>();
            }

            for (int roadNum = 0; roadNum < roadCnt; roadNum++) {
                StringTokenizer roadInfo = new StringTokenizer(br.readLine());
                int aCity = Integer.parseInt(roadInfo.nextToken()) - 1;
                int bCity = Integer.parseInt(roadInfo.nextToken()) - 1;

                roads[aCity].add(bCity);
                roads[bCity].add(aCity);
            }

            int queryCnt = Integer.parseInt(br.readLine());
            for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
                StringTokenizer queryInfo = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(queryInfo.nextToken());
                int aCity = Integer.parseInt(queryInfo.nextToken()) - 1;
                int bCity = Integer.parseInt(queryInfo.nextToken()) - 1;

                if (command == 1) {
                    roads[aCity].add(bCity);
                    roads[bCity].add(aCity);
                } else {
                    roads[aCity].remove(bCity);
                    roads[bCity].remove(aCity);
                }

                int[] minDist = calDist(cityCnt, roads);
                for (int dist : minDist) {
                    sb.append(dist).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int[] calDist(int cityCnt, HashSet<Integer>[] roads) {
        int[] dist = new int[cityCnt];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        dist[0] = 0;
        q.add(0);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : roads[cur]) {
                if (dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        return dist;
    }
}
