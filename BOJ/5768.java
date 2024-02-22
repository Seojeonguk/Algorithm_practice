import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer inputs = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(inputs.nextToken());
            int n = Integer.parseInt(inputs.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            int maxDivisorCnt = 0;
            int maxDivisor = 0;
            for (int i = m; i <= n; i++) {
                int divisorCnt = calDivisorCnt(i);
                if (maxDivisorCnt <= divisorCnt) {
                    maxDivisorCnt = divisorCnt;
                    maxDivisor = i;
                }
            }

            sb.append(maxDivisor).append(" ").append(maxDivisorCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calDivisorCnt(int x) {
        int divisorCnt = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                divisorCnt++;
                if (x / i != i) {
                    divisorCnt++;
                }
            }
        }

        return divisorCnt;
    }
}
