import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int VOTE_YEAR = 2007;
    static int VOTE_MONTH = 2;
    static int VOTE_DAY = 27;

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            if (VOTE_YEAR - 18 > year) {
                sb.append("Yes\n");
            } else if (VOTE_YEAR - 18 == year) {
                if (month > VOTE_MONTH) {
                    sb.append("No\n");
                } else if (month < VOTE_MONTH) {
                    sb.append("Yes\n");
                } else {
                    if (day > VOTE_DAY) {
                        sb.append("No\n");
                    } else {
                        sb.append("Yes\n");
                    }
                }
            } else {
                sb.append("No\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
