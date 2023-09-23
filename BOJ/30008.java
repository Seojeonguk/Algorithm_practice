import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[] RATING = {4, 11, 23, 40, 60, 77, 89, 96, 100};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int subjectCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        while (subjectCnt-- > 0) {
            int rank = Integer.parseInt(st.nextToken());
            int percentage = rank * 100 / studentCnt;

            for (int idx = 0; idx < RATING.length; idx++) {
                if (percentage <= RATING[idx]) {
                    sb.append(idx + 1).append(" ");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
