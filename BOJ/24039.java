import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                continue;
            }
            primes.add(i);
            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = true;
            }
        }

        for (int idx = 0; idx < primes.size() - 1; idx++) {
            int multipleTwoPrime = primes.get(idx) * primes.get(idx + 1);
            if (n < multipleTwoPrime) {
                sb.append(multipleTwoPrime);
                break;
            }
        }

        if (n < 3) {
            sb.append(6);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
