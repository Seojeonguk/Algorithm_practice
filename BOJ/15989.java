import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX_CASE = 10000;

    public static void main(String[] args) throws Exception {
        int[] cases = new int[MAX_CASE + 1];
        cases[1] = 1;
        cases[2] = 2;
        cases[3] = 3;
        for (int i = 4; i <= MAX_CASE; i++) {
            cases[i] = cases[i - 3] + i / 2 + 1;
        }
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(cases[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}