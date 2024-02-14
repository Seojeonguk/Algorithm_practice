import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_VALUE = 50;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int talkingCnt = Integer.parseInt(br.readLine());
        int[] appearedNumCounts = new int[MAX_VALUE + 1];
        StringTokenizer talkingInfo = new StringTokenizer(br.readLine());
        for (int i = 0; i < talkingCnt; i++) {
            int value = Integer.parseInt(talkingInfo.nextToken());
            appearedNumCounts[value]++;
        }

        for (int i = MAX_VALUE; i >= 0; i--) {
            if (i == appearedNumCounts[i]) {
                sb.append(i);
                break;
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
