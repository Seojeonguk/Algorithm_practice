import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int CHILD_CNT = 20;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        int[] heights = new int[CHILD_CNT];
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int testCaseNum = Integer.parseInt(st.nextToken());
            int backStepCnt = 0;
            for (int idx = 0; idx < CHILD_CNT; idx++) {
                heights[idx] = Integer.parseInt(st.nextToken());
            }

            for (int i = CHILD_CNT - 1; i >= 0; i--) {
                for (int j = i + 1; j < CHILD_CNT; j++) {
                    if (heights[i] > heights[j]) {
                        backStepCnt++;
                    }
                }
            }
            sb.append(testCaseNum).append(" ").append(backStepCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
