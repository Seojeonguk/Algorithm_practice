import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            int teamCnt = Integer.parseInt(br.readLine());
            if (teamCnt == 0) {
                break;
            }
            int sponsorTeam = -1;
            int minDiff = 100000;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= teamCnt; i++) {
                int answerTime = Integer.parseInt(st.nextToken());
                int diff = Math.abs(answerTime - 2023);
                if (diff < minDiff) {
                    minDiff = diff;
                    sponsorTeam = i;
                }
            }

            sb.append(sponsorTeam).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
