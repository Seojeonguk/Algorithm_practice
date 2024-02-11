import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            char[] sequence = br.readLine().toCharArray();
            int idx = 0;
            while (idx < sequence.length) {
                int sameCnt = 0;
                while (idx + sameCnt < sequence.length && sequence[idx + sameCnt] == sequence[idx]) {
                    sameCnt++;
                }
                sb.append(sameCnt).append(sequence[idx]);
                idx += sameCnt;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
