import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    static final int LIMIT_TIME = 490;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            BigInteger[] affectedCows = new BigInteger[LIMIT_TIME + 1];
            affectedCows[0] = BigInteger.ZERO;
            affectedCows[1] = BigInteger.ONE;
            for (int i = 2; i <= LIMIT_TIME; i++) {
                affectedCows[i] = affectedCows[i - 1].add(affectedCows[i - 2]);
            }

            while (true) {
                int time = Integer.parseInt(br.readLine());
                if (time == -1) {
                    break;
                }

                sb.append(String.format("Hour %d: %d cow(s) affected\n", time, affectedCows[time]));
            }

            bw.write(sb.toString());
        }
    }
}
