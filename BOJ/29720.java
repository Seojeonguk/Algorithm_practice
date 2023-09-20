import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int targetProblemCnt = Integer.parseInt(st.nextToken());
        int solvedProblemCntPerDay = Integer.parseInt(st.nextToken());
        int targetProblemForDay = Integer.parseInt(st.nextToken());

        int minSolvedProblem = Math.max(0, targetProblemCnt - solvedProblemCntPerDay * targetProblemForDay);
        int maxSolvedProblem = targetProblemCnt - solvedProblemCntPerDay * (targetProblemForDay - 1) - 1;
        sb.append(String.format("%d %d", minSolvedProblem, maxSolvedProblem));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
