import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            br.readLine();

            BigInteger fac = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                fac = fac.multiply(BigInteger.valueOf(i));
            }

            int[] appearedCnt = new int[10];
            char[] strFac = fac.toString().toCharArray();
            for (int i = 0; i < strFac.length; i++) {
                appearedCnt[strFac[i] - '0']++;
            }

            sb.append(n).append("! --\n");
            for (int i = 0; i < 10; i++) {
                sb.append(String.format("   (%d)%5d ", i, appearedCnt[i]));
                if (i % 5 == 4) {
                    sb.append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
