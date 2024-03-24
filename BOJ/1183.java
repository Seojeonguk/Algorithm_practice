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

        int promiseCnt = Integer.parseInt(br.readLine());
        int[] diff = new int[promiseCnt];
        for (int i = 0; i < promiseCnt; i++) {
            StringTokenizer promiseInfo = new StringTokenizer(br.readLine());
            int promiseTime = Integer.parseInt(promiseInfo.nextToken());
            int destinationTime = Integer.parseInt(promiseInfo.nextToken());

            diff[i] = promiseTime - destinationTime;
        }

        int minWaitingTimeCnt = calMinWaitingTimeCnt(diff);
        sb.append(minWaitingTimeCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMinWaitingTimeCnt(int[] diff) {
        if (diff.length % 2 == 1) {
            return 1;
        }

        Arrays.sort(diff);
        return diff[diff.length / 2] - diff[diff.length / 2 - 1] + 1;
    }
}
