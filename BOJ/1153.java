import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i + i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        int[] ans = calPrime(isNotPrime, n);
        for (int prime : ans) {
            sb.append(prime).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] calPrime(boolean[] isNotPrime, int n) {
        int[] ans = new int[4];
        if (n % 2 == 1) {
            if (n < 9) {
                return new int[]{-1};
            }
            ans[0] = 2;
            ans[1] = 3;
            n -= 5;
        } else {
            if (n < 8) {
                return new int[]{-1};
            }
            ans[0] = 2;
            ans[1] = 2;
            n -= 4;
        }

        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i] && !isNotPrime[n - i]) {
                ans[2] = i;
                ans[3] = n - i;
                break;
            }
        }

        return ans;
    }
}
