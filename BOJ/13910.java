import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100000000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int noodleCnt = Integer.parseInt(st.nextToken());
            int hasWokCnt = Integer.parseInt(st.nextToken());

            StringTokenizer wokInfo = new StringTokenizer(br.readLine());
            int[] woks = new int[hasWokCnt];
            for (int wokNum = 0; wokNum < hasWokCnt; wokNum++) {
                woks[wokNum] = Integer.parseInt(wokInfo.nextToken());
            }

            boolean[] chk = new boolean[2 * noodleCnt + 1];
            chk[0] = true;
            for (int i = 0; i < hasWokCnt; i++) {
                chk[woks[i]] = true;
                for (int j = i + 1; j < hasWokCnt; j++) {
                    chk[woks[i] + woks[j]] = true;
                }
            }

            int[] dp = new int[noodleCnt + 1];
            for (int i = 1; i <= noodleCnt; i++) {
                dp[i] = MAX;
            }
            for (int i = 1; i <= noodleCnt; i++) {
                if (!chk[i]) {
                    continue;
                }

                for (int j = i; j <= noodleCnt; j++) {
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }

            sb.append(dp[noodleCnt] != MAX ? dp[noodleCnt] : -1);

            bw.write(sb.toString());
        }
    }
}
