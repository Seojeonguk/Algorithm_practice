import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int UPPER_SIZE = 4;
    final static int LOWER_OR_DIGIT_SIZE = 2;
    final static int EMPTY_SIZE = 1;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int weedCnt = Integer.parseInt(st.nextToken());
        int problemCnt = Integer.parseInt(st.nextToken());

        int possibleSolvingProblem = 0;
        while (problemCnt-- > 0) {
            String problem = br.readLine();
            int problemSize = 0;
            for (int idx = 0; idx < problem.length(); idx++) {
                char c = problem.charAt(idx);
                if (Character.isUpperCase(c)) {
                    problemSize += UPPER_SIZE;
                } else if (Character.isLowerCase(c) || Character.isDigit(c)) {
                    problemSize += LOWER_OR_DIGIT_SIZE;
                } else {
                    problemSize += EMPTY_SIZE;
                }
            }
            if (weedCnt >= problemSize) {
                possibleSolvingProblem++;
            }
        }
        sb.append(possibleSolvingProblem);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
