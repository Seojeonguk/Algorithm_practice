import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            String foundNum = st.nextToken();

            ArrayList<Integer> primes = getPrimes(start, end);
            int appearedCnt = 0;
            for (int prime : primes) {
                if (String.valueOf(prime).contains(foundNum)) {
                    appearedCnt++;
                }
            }

            sb.append(appearedCnt);

            bw.write(sb.toString());
        }
    }

    public static ArrayList<Integer> getPrimes(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrimes = new boolean[end + 1];

        for (int i = 2; i <= end; i++) {
            if (isPrimes[i]) {
                continue;
            }

            if (start <= i) {
                primes.add(i);
            }

            for (int j = i + i; j <= end; j += i) {
                isPrimes[j] = true;
            }
        }

        return primes;
    }
}
