import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sampleCnt = Integer.parseInt(st.nextToken());
            int windowSize = Integer.parseInt(st.nextToken());

            StringTokenizer samplesToken = new StringTokenizer(br.readLine());
            int[] samples = new int[sampleCnt + 1];
            int[] prefixSum = new int[sampleCnt + 1];
            for (int i = 1; i <= sampleCnt; i++) {
                samples[i] = Integer.parseInt(samplesToken.nextToken());
                prefixSum[i] = samples[i] + prefixSum[i - 1];
            }

            int minAverage = Integer.MAX_VALUE, maxAverage = Integer.MIN_VALUE;
            for (int i = windowSize; i <= sampleCnt; i++) {
                int average = (prefixSum[i] - prefixSum[i - windowSize]) / windowSize;
                minAverage = Math.min(minAverage, average);
                maxAverage = Math.max(maxAverage, average);
            }

            int absoluteDiff = Math.abs(maxAverage - minAverage);
            sb.append("Data Set ").append(tc).append(":\n").append(absoluteDiff).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
