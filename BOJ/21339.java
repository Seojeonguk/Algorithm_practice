import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalProblemCnt = Integer.parseInt(st.nextToken());
        int solvedProblemCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int averageDifficulty = Integer.parseInt(st.nextToken());
        int solvedAverageDifficulty = Integer.parseInt(st.nextToken());

        int sumRemainedProblemDifficulty = totalProblemCnt * averageDifficulty - solvedProblemCnt * solvedAverageDifficulty;
        sb.append((totalProblemCnt - solvedProblemCnt) * 100 < sumRemainedProblemDifficulty || sumRemainedProblemDifficulty < 0 ? "impossible" : 1.0f * sumRemainedProblemDifficulty / (totalProblemCnt - solvedProblemCnt));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
