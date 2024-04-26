import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int orchardSize = Integer.parseInt(br.readLine());

            int[][] profits = new int[orchardSize + 1][orchardSize + 1];
            int[][] prefixSums = new int[orchardSize + 1][orchardSize + 1];

            for (int row = 1; row <= orchardSize; row++) {
                StringTokenizer rowProfits = new StringTokenizer(br.readLine());
                for (int col = 1; col <= orchardSize; col++) {
                    profits[row][col] = Integer.parseInt(rowProfits.nextToken());
                    prefixSums[row][col] = prefixSums[row - 1][col] + prefixSums[row][col - 1] - prefixSums[row - 1][col - 1] + profits[row][col];
                }
            }

            int maxProfits = Integer.MIN_VALUE;
            for (int k = 1; k <= orchardSize; k++) {
                for (int i = k; i <= orchardSize; i++) {
                    for (int j = k; j <= orchardSize; j++) {
                        int profit = prefixSums[i][j] - prefixSums[i - k][j] - prefixSums[i][j - k] + prefixSums[i - k][j - k];
                        maxProfits = Math.max(maxProfits, profit);
                    }
                }
            }

            sb.append(maxProfits);

            bw.write(sb.toString());
        }
    }
}
