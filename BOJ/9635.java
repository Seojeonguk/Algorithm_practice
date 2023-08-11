import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            int problemCnt = Integer.parseInt(st.nextToken());
            int canNotEasiestProblemColor = Integer.parseInt(st.nextToken());
            int canNotHardestProblemColor = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] problemColors = new int[problemCnt];
            for (int i = 0; i < problemCnt; i++) {
                problemColors[i] = Integer.parseInt(st.nextToken());
            }
            if (problemColors[0] == canNotEasiestProblemColor && problemColors[problemCnt - 1] == canNotHardestProblemColor) {
                sb.append("BOTH");
            } else if (problemColors[0] == canNotEasiestProblemColor) {
                sb.append("EASY");
            } else if (problemColors[problemCnt - 1] == canNotHardestProblemColor) {
                sb.append("HARD");
            } else {
                sb.append("OKAY");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
