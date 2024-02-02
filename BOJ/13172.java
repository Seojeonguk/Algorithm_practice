import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalDice = Integer.parseInt(br.readLine());

        long totalE = 0;
        for (int i = 0; i < totalDice; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int diceSide = Integer.parseInt(st.nextToken());
            int sumDiceNum = Integer.parseInt(st.nextToken());

            totalE = (totalE + calE(diceSide, sumDiceNum)) % MOD;
        }

        sb.append(totalE);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calE(int diceSide, int sumDiceNum) {
        return inverse(diceSide, MOD - 2) * sumDiceNum;
    }

    public static long inverse(int a, int pow) {
        if (pow == 0) {
            return 1;
        }
        long half = inverse(a, pow / 2);
        long ret = (half * half) % MOD;
        if (pow % 2 > 0) {
            ret = (ret * a) % MOD;
        }
        return ret;
    }
}
