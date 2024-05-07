import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cycleCnt = Integer.parseInt(st.nextToken());
            int dessertCnt = Integer.parseInt(st.nextToken());

            int[][] happiness = new int[dessertCnt + 1][cycleCnt + 1];
            for (int dessertNum = 1; dessertNum <= dessertCnt; dessertNum++) {
                StringTokenizer dessertHappiness = new StringTokenizer(br.readLine());
                for (int day = 1; day <= cycleCnt; day++) {
                    happiness[dessertNum][day] = Integer.parseInt(dessertHappiness.nextToken());
                }
            }

            int[][] dp = new int[dessertCnt + 1][cycleCnt + 1];
            for (int day = 1; day <= cycleCnt; day++) {
                for (int dessertNum = 1; dessertNum <= dessertCnt; dessertNum++) {
                    int maxPrevDp = 0;
                    for (int j = 1; j <= dessertCnt; j++) {
                        if (j == dessertNum) {
                            continue;
                        }
                        maxPrevDp = Math.max(maxPrevDp, dp[j][day - 1]);
                    }
                    dp[dessertNum][day] = Math.max(maxPrevDp + happiness[dessertNum][day], dp[dessertNum][day - 1] + happiness[dessertNum][day] / 2);
                }
            }

            int maxHappiness = 0;
            for (int dessertNum = 1; dessertNum <= dessertCnt; dessertNum++) {
                maxHappiness = Math.max(maxHappiness, dp[dessertNum][cycleCnt]);
            }

            sb.append(maxHappiness);

            bw.write(sb.toString());
        }
    }
}
