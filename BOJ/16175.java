import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int candidateCnt = Integer.parseInt(st.nextToken());
            int voteRegionCnt = Integer.parseInt(st.nextToken());

            int[] votes = new int[candidateCnt];
            for (int i = 0; i < voteRegionCnt; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < candidateCnt; j++) {
                    votes[j] += Integer.parseInt(st.nextToken());
                }
            }
            int winner = 0;
            for (int idx = 0; idx < candidateCnt; idx++) {
                if (votes[winner] < votes[idx]) {
                    winner = idx;
                }
            }
            sb.append(winner + 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
