import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static final int MOD = 123456789;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int cost = Integer.parseInt(br.readLine());
            ArrayList<Integer> primes = getPrimes(cost);

            int[] dp = new int[cost + 1];
            for (int prime : primes) {
                dp[prime] = (dp[prime] + 1) % MOD;
                for (int j = 0; j <= cost; j++) {
                    if (j + prime > cost) {
                        break;
                    }

                    dp[j + prime] = (dp[j + prime] + dp[j]) % MOD;
                }
            }

            sb.append(dp[cost]);

            bw.write(sb.toString());
        }
    }

    public static ArrayList<Integer> getPrimes(int max) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] notPrimes = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            if (notPrimes[i]) {
                continue;
            }

            primes.add(i);

            for (int j = i + i; j <= max; j += i) {
                notPrimes[j] = true;
            }
        }

        return primes;
    }
}
