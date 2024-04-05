import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_SIZE = 1000;
    static final int MAX_FUEL = 100;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer sizeInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(sizeInfo.nextToken());
        int colSize = Integer.parseInt(sizeInfo.nextToken());

        int[][] requiredFuels = new int[rowSize + 2][colSize + 2];
        int[][][] dp = new int[rowSize + 2][colSize + 2][3];

        for (int row = 1; row <= rowSize; row++) {
            StringTokenizer fuelInfo = new StringTokenizer(br.readLine());
            for (int col = 1; col <= colSize; col++) {
                requiredFuels[row][col] = Integer.parseInt(fuelInfo.nextToken());

                for (int dir = 0; dir < 3; dir++) {
                    dp[row][col][dir] = MAX_SIZE * MAX_SIZE + 1;
                }
            }

            for (int dir = 0; dir < 3; dir++) {
                dp[row][0][dir] = dp[row][colSize + 1][dir] = MAX_SIZE * MAX_SIZE + 1;
            }
        }


        for (int row = 1; row <= rowSize; row++) {
            for (int col = 1; col <= colSize; col++) {
                dp[row][col][0] = Math.min(dp[row - 1][col][1], dp[row - 1][col - 1][2]) + requiredFuels[row][col];
                dp[row][col][1] = Math.min(dp[row - 1][col + 1][0], dp[row - 1][col - 1][2]) + requiredFuels[row][col];
                dp[row][col][2] = Math.min(dp[row - 1][col + 1][0], dp[row - 1][col][1]) + requiredFuels[row][col];
            }
        }

        int minRequiredFuels = Integer.MAX_VALUE;
        for (int col = 1; col <= colSize; col++) {
            for (int dir = 0; dir < 3; dir++) {
                minRequiredFuels = Math.min(minRequiredFuels, dp[rowSize][col][dir]);
            }
        }

        sb.append(minRequiredFuels);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
