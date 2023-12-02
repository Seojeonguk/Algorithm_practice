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

    static final int WATERMELON_CNT = 4;

    public static void main(String[] args) throws Exception {
        int[] watermelonWeights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sb.append(calMinDiff(watermelonWeights, 0, 0, 0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMinDiff(int[] weights, int leftWeight, int rightWeight, int cnt) {
        if (cnt == WATERMELON_CNT) {
            return Math.abs(leftWeight - rightWeight);
        }

        int minWeight = Integer.MAX_VALUE;
        minWeight = Math.min(minWeight, calMinDiff(weights, leftWeight + weights[cnt], rightWeight, cnt + 1));
        minWeight = Math.min(minWeight, calMinDiff(weights, leftWeight, rightWeight + weights[cnt], cnt + 1));

        return minWeight;
    }
}
