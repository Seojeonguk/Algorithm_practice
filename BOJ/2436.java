import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX = 100000000;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int greatestCommonDivisor = Integer.parseInt(st.nextToken());
        int leastCommonMultiple = Integer.parseInt(st.nextToken());

        int restDivisor = leastCommonMultiple / greatestCommonDivisor;
        ArrayList<Integer> divisors = new ArrayList<>();
        int divisor = 2;
        while (restDivisor != 1) {
            int divisorMultiple = 1;
            while (restDivisor % divisor == 0) {
                divisorMultiple *= divisor;
                restDivisor /= divisor;
            }
            if (divisorMultiple != 1) {
                divisors.add(divisorMultiple);
            }
            divisor++;

        }

        int[] leastPairs = new int[2];
        leastPairs[0] = leastPairs[1] = MAX;
        solve(leastPairs, divisors, 0, greatestCommonDivisor, greatestCommonDivisor);

        sb.append(String.format("%d %d", leastPairs[0], leastPairs[1]));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int[] leastPairs, ArrayList<Integer> divisors, int idx, int a, int b) {
        if (idx == divisors.size()) {
            if (leastPairs[0] + leastPairs[1] > a + b) {
                leastPairs[0] = Math.min(a, b);
                leastPairs[1] = Math.max(a, b);
            }
            return;
        }
        int value = divisors.get(idx);
        solve(leastPairs, divisors, idx + 1, a * value, b);
        solve(leastPairs, divisors, idx + 1, a, b * value);
    }
}
