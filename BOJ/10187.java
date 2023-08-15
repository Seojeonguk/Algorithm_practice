import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            sb.append(String.format("%s\n", isGoldenRatio(a, b) ? "golden" : "not"));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isGoldenRatio(double a, double b) {
        double ratio = a / b;
        double tolerance = 0.01;
        return Math.abs(ratio - GOLDEN_RATIO) / GOLDEN_RATIO <= tolerance;
    }
}