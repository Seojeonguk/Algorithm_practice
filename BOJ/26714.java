import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCnt = Integer.parseInt(br.readLine());
        String test = br.readLine();
        int score = 0;
        for (int i = 0; i < testCnt; i += testCnt / 10) {
            int testSuccessCnt = 0;
            for (int j = i; j < i + testCnt / 10; j++) {
                if (test.charAt(j) == 'T') {
                    testSuccessCnt++;
                }
            }
            if (testSuccessCnt == testCnt / 10) {
                score++;
            }
        }

        sb.append(score);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
