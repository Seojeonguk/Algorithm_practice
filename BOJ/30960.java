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

        int studentCnt = Integer.parseInt(br.readLine());
        int[] studentNums = new int[studentCnt + 1];
        StringTokenizer studentNumToken = new StringTokenizer(br.readLine());
        for (int i = 1; i <= studentCnt; i++) {
            studentNums[i] = Integer.parseInt(studentNumToken.nextToken());
        }

        Arrays.sort(studentNums);

        long[] prefixSums = new long[studentCnt + 1];
        for (int i = 1; i <= studentCnt; i++) {
            prefixSums[i] = prefixSums[i - 1] + (i % 2 == 1 ? studentNums[i] : -studentNums[i]);
        }

        long minAwkwardSum = calMinAwkwardSum(studentCnt, studentNums, prefixSums);

        sb.append(minAwkwardSum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calMinAwkwardSum(int studentCnt, int[] studentNums, long[] prefixSums) {
        long minAwkwardSum = Long.MAX_VALUE;
        for (int i = 3; i <= studentCnt; i += 2) {
            minAwkwardSum = Math.min(minAwkwardSum, -prefixSums[i - 3] + studentNums[i] - studentNums[i - 2] + prefixSums[studentCnt] - prefixSums[i]);
        }

        return minAwkwardSum;
    }
}
