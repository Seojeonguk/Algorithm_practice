import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    static final int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isNotPrimes = new boolean[MAX + 1];

        isNotPrimes[1] = true;
        for (int i = 2; i <= MAX; i++) {
            if (isNotPrimes[i]) {
                continue;
            }
            primes.add(i);
            for (int j = i + i; j <= MAX; j += i) {
                isNotPrimes[j] = true;
            }
        }

        TreeSet<Integer> continuousSums = new TreeSet<>();
        for (int i = 0; i < primes.size(); i++) {
            int sum = 0, cnt = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);
                cnt++;
                if (sum > MAX) {
                    break;
                }
                if (!isNotPrimes[cnt]) {
                    continuousSums.add(sum);
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            sb.append(continuousSums.contains(n) ? "SIM" : "NAO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
