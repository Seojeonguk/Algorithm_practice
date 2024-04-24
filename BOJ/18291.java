import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int steppingStoneCnt = Integer.parseInt(br.readLine());

                sb.append(calCaseNum(2, Math.max(0, steppingStoneCnt - 2))).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static long calCaseNum(int base, int power) {
        if (power == 0) {
            return 1;
        }

        long half = calCaseNum(base, power / 2);
        long ret = (half * half) % MOD;
        if (power % 2 == 1) {
            ret = (ret * base) % MOD;
        }

        return ret;
    }
}
