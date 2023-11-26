import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int problemCnt = Integer.parseInt(st.nextToken());
        int minSum = Integer.parseInt(st.nextToken());
        int maxSum = Integer.parseInt(st.nextToken());
        int minLevelDiff = Integer.parseInt(st.nextToken());

        int[] problems = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] isSelect = new boolean[(1 << problemCnt) + 1];

        int caseCnt = selectProblem(problems, isSelect, 0, minSum, 0, maxSum, minLevelDiff);
        sb.append(caseCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int selectProblem(int[] problems, boolean[] isSelect, int selectProblem, int minSum, int sum, int maxSum, int minLevelDiff) {
        int selectedMinLevel = 1000001, selectedMaxLevel = -1;
        for (int i = 0; i < problems.length; i++) {
            if ((selectProblem & (1 << i)) != 0) {
                selectedMinLevel = Math.min(selectedMinLevel, problems[i]);
                selectedMaxLevel = Math.max(selectedMaxLevel, problems[i]);
            }
        }
        int caseCnt = (minSum <= sum && sum <= maxSum && selectedMaxLevel - selectedMinLevel >= minLevelDiff ? 1 : 0);
        if (selectProblem == (1 << problems.length) - 1) {
            return caseCnt;
        }

        for (int i = 0; i < problems.length; i++) {
            int next = (selectProblem | (1 << i));
            if (isSelect[next]) {
                continue;
            }
            isSelect[next] = true;
            caseCnt += selectProblem(problems, isSelect, next, minSum, sum + problems[i], maxSum, minLevelDiff);
        }

        return caseCnt;
    }
}
