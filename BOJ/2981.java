import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int wroteNum = Integer.parseInt(br.readLine());
        int[] wroteNumbers = new int[wroteNum];
        for (int i = 0; i < wroteNum; i++) {
            wroteNumbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(wroteNumbers);
        int g = wroteNumbers[1] - wroteNumbers[0];
        for (int i = 2; i < wroteNum; i++) {
            int diff = wroteNumbers[i] - wroteNumbers[i - 1];
            g = gcd(g, diff);
        }

        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                ans.add(i);
                ans.add(g / i);
            }
        }

        for (int i : ans) {
            if (i == 1) {
                continue;
            }
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
