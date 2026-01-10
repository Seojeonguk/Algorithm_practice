import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int addCnt = Integer.parseInt(br.readLine());

            char[] expression = br.readLine().replaceAll(" ", "").toCharArray();
            boolean isOver = false;
            int sum = 0;

            for (int idx = 0; idx < expression.length; idx += 2) {
                if (expression[idx] == '!') {
                    isOver = true;
                    break;
                } else {
                    sum += (expression[idx] - '0');
                }
            }

            if (9 < sum) {
                isOver = true;
            }

            sb.append(isOver ? "!" : sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
