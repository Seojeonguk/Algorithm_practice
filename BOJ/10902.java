import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int submittedAnswerCnt = Integer.parseInt(br.readLine());
        int minK = 0;
        int maxScore = 0;
        int maxScoreSubmissionTime = 0;

        for (int submittedAnswer = 1; submittedAnswer <= submittedAnswerCnt; submittedAnswer++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            if (maxScore < score) {
                minK = submittedAnswer;
                maxScoreSubmissionTime = time;
                maxScore = score;
            }
        }

        int penalty = 0;
        if (maxScore != 0) {
            penalty = maxScoreSubmissionTime + (minK - 1) * 20;
        }

        sb.append(penalty);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
