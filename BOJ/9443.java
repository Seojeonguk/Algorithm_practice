import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int proposalCnt = Integer.parseInt(br.readLine());

        boolean[] isAppeared = new boolean[26];

        for (int i = 0; i < proposalCnt; i++) {
            String contest = br.readLine();
            isAppeared[contest.charAt(0) - 'A'] = true;
        }

        int maxGoodContestCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (!isAppeared[i]) {
                break;
            }
            maxGoodContestCnt++;
        }

        sb.append(maxGoodContestCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
