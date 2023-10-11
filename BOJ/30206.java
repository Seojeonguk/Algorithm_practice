import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());

        int[] depths = new int[pointCnt + 1];
        int[] depthCnts = new int[pointCnt + 1];


        ArrayList<Integer>[] roads = new ArrayList[pointCnt + 1];
        for (int i = 1; i <= pointCnt; i++) {
            roads[i] = new ArrayList();
        }

        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int aPoint = Integer.parseInt(st.nextToken());
            int bPoint = Integer.parseInt(st.nextToken());

            roads[aPoint].add(bPoint);
            roads[bPoint].add(aPoint);
        }

        Queue<Integer> q = new LinkedList<>();
        depths[1] = 1;
        q.add(1);

        while (!q.isEmpty()) {
            int curPoint = q.poll();

            depthCnts[depths[curPoint]]++;

            for (int nextPoint : roads[curPoint]) {
                if (depths[nextPoint] > 0) {
                    continue;
                }
                depths[nextPoint] = depths[curPoint] + 1;
                q.add(nextPoint);
            }
        }

        long sum = 2;
        for (int depth = 2; depth <= pointCnt && depthCnts[depth] > 0; depth++) {
            sum = (sum * (depthCnts[depth] + 1)) % MOD;
        }
        sb.append(sum - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
