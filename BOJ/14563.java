import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(solve(n)).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String solve(int n) {
        String ret = "";

        int sumDivisor = 0;

        for (int divisor = 1; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) {
                if (n != 1) {
                    sumDivisor += divisor;
                }
                if (n / divisor != divisor && n / divisor != n) {
                    sumDivisor += n / divisor;
                }
            }
        }

        if (sumDivisor > n) {
            ret = "Abundant";
        } else if (sumDivisor < n) {
            ret = "Deficient";
        } else {
            ret = "Perfect";
        }

        return ret;
    }
}
