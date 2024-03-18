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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrimes = new boolean[b + 1];
        for (int i = 2; i <= b; i++) {
            if (isPrimes[i]) {
                continue;
            }

            if (i >= a) {
                if (isPalindrome(i)) {
                    sb.append(i).append("\n");
                }
            }

            for (int j = i + i; j <= b; j += i) {
                isPrimes[j] = true;
            }
        }

        sb.append(-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPalindrome(int x) {
        char[] c = String.valueOf(x).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
