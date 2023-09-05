import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int EASY_PROBLEM_SCORE = 100;
    final static int HARD_PROBLEM_SCORE = 140;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int problemCnt = Integer.parseInt(st.nextToken());
        int capability = Integer.parseInt(st.nextToken());
        int possibleProblemCnt = Integer.parseInt(st.nextToken());

        int easyProblemCnt = 0, hardProblemCnt = 0;
        for (int i = 0; i < problemCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int easy = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());

            if (hard <= capability) {
                hardProblemCnt++;
            } else if (easy <= capability) {
                easyProblemCnt++;
            }
        }

        int maxScore = 0;
        int possibleHardProblem = Math.min(possibleProblemCnt, hardProblemCnt);
        maxScore = possibleHardProblem * HARD_PROBLEM_SCORE;
        possibleProblemCnt -= possibleHardProblem;
        int possibleEasyProblem = Math.min(possibleProblemCnt, easyProblemCnt);
        maxScore += possibleEasyProblem * EASY_PROBLEM_SCORE;
        
        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
