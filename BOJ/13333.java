import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int dissertationCnt = Integer.parseInt(br.readLine());
        StringTokenizer quoteInfo = new StringTokenizer(br.readLine());
        int[] quotes = new int[dissertationCnt];

        for (int idx = 0; idx < dissertationCnt; idx++) {
            quotes[idx] = Integer.parseInt(quoteInfo.nextToken());
        }

        Arrays.sort(quotes);

        for (int q = dissertationCnt; q >= 0; q--) {
            int overQCnt = 0;
            for (int idx = 0; idx < dissertationCnt; idx++) {
                if (quotes[idx] >= q) {
                    overQCnt++;
                }
            }

            if (overQCnt >= q) {
                sb.append(q);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
