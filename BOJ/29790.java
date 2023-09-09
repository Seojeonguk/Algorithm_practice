import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int QUALIFICATION_SUBMIT_PROBLEM = 1000;
    final static int QUALIFICATION_UNION = 8000;
    final static int QUALIFICATION_MAX_LEVEL = 260;

    final static String SATISFY_ALL_QUALIFICATION = "Very Good";
    final static String SATISFY_PROBLEM_QUALIFICATION = "Good";
    final static String UNSATISFY = "Bad";

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int solvedProblemCnt = Integer.parseInt(st.nextToken());
        int union = Integer.parseInt(st.nextToken());
        int maxLevel = Integer.parseInt(st.nextToken());

        boolean canSubmitProblem = solvedProblemCnt >= QUALIFICATION_SUBMIT_PROBLEM;
        boolean isSatisfyMaple = (union >= QUALIFICATION_UNION || maxLevel >= QUALIFICATION_MAX_LEVEL);

        if (canSubmitProblem && isSatisfyMaple) {
            sb.append(SATISFY_ALL_QUALIFICATION);
        } else if (canSubmitProblem) {
            sb.append(SATISFY_PROBLEM_QUALIFICATION);
        } else {
            sb.append(UNSATISFY);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
