import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static double EITPerMonth = 0.0833333;

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            int infectionMonth = Integer.parseInt(st.nextToken());
            int infectionYear = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int strikeMonth = Integer.parseInt(st.nextToken());
            int strikeYear = Integer.parseInt(st.nextToken());

            double ans = 0;
            if (infectionYear == strikeYear) {
                if (strikeMonth == 12) {
                    ans = 0.5;
                } else {
                    double firstYearEITPerMonth = 0.5 / (12 - infectionMonth + 1);
                    ans = firstYearEITPerMonth * (strikeMonth - infectionMonth);
                }
            } else {
                ans = 0.5 + (strikeYear - infectionYear - 1) + EITPerMonth * (strikeMonth - 1);
            }
            sb.append(String.format("%.4f", ans)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
