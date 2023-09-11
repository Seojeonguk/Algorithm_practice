import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rangeStart = Integer.parseInt(st.nextToken());
        int rangeEnd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int solvingProblemCnt = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        int start = Math.max(rangeStart, solvingProblemCnt - diff);
        int end = Math.min(rangeEnd, solvingProblemCnt + diff);

        if (start > solvingProblemCnt + diff || end < solvingProblemCnt - diff) {
            sb.append("IMPOSSIBLE");
        } else {
            sb.append(end - start + 1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
