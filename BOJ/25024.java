import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean canMakeTime = (x < 24 && y < 60);
            boolean canMakeDay = (0 < x && x < 13 && 0 < y && y <= DAYS[x]);

            sb.append(String.format("%s %s\n", canMakeTime ? "Yes" : "No", canMakeDay ? "Yes" : "No"));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
