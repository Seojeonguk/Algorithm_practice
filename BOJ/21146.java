import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MIN_RATING = -3;
    final static int MAX_RATING = 3;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int judgeCnt = Integer.parseInt(st.nextToken());
        int ratedJudgeCnt = Integer.parseInt(st.nextToken());
        int sumRatedProblem = 0;
        for (int i = 0; i < ratedJudgeCnt; i++) {
            sumRatedProblem += Integer.parseInt(br.readLine());
        }

        int minRating = sumRatedProblem + (judgeCnt - ratedJudgeCnt) * MIN_RATING;
        int maxRating = sumRatedProblem + (judgeCnt - ratedJudgeCnt) * MAX_RATING;

        sb.append(1.0f * minRating / judgeCnt).append(" ").append(1.0f * maxRating / judgeCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
