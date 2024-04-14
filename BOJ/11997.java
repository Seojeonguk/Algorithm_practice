import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cowCnt = Integer.parseInt(br.readLine());
        int[] cowX = new int[cowCnt];
        int[] cowY = new int[cowCnt];

        for (int cowNum = 0; cowNum < cowCnt; cowNum++) {
            StringTokenizer cowInfo = new StringTokenizer(br.readLine());
            cowX[cowNum] = Integer.parseInt(cowInfo.nextToken());
            cowY[cowNum] = Integer.parseInt(cowInfo.nextToken());
        }

        HashMap<Integer, Integer> xIdx = new HashMap<>();
        HashMap<Integer, Integer> yIdx = new HashMap<>();
        Arrays.stream(cowX).distinct().sorted().forEach(x -> xIdx.put(x, xIdx.size()));
        Arrays.stream(cowY).distinct().sorted().forEach(x -> yIdx.put(x, yIdx.size()));

        int[][] zips = new int[cowCnt][cowCnt];
        for (int i = 0; i < cowCnt; i++) {
            zips[xIdx.get(cowX[i])][yIdx.get(cowY[i])]++;
        }

        int[][] prefixSums = new int[cowCnt + 1][cowCnt + 1];
        int xSize = xIdx.size(), ySize = yIdx.size();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                prefixSums[i + 1][j + 1] = prefixSums[i + 1][j] + prefixSums[i][j + 1] - prefixSums[i][j] + zips[i][j];
            }
        }

        int smallestMaximumCows = cowCnt;
        for (int i = 0; i <= xSize; i++) {
            for (int j = 0; j <= ySize; j++) {
                int maxAreaCow = 0;
                maxAreaCow = Math.max(maxAreaCow, rangeSum(prefixSums, 0, 0, i, j));
                maxAreaCow = Math.max(maxAreaCow, rangeSum(prefixSums, 0, j, i, ySize));
                maxAreaCow = Math.max(maxAreaCow, rangeSum(prefixSums, i, 0, xSize, j));
                maxAreaCow = Math.max(maxAreaCow, rangeSum(prefixSums, i, j, xSize, ySize));

                smallestMaximumCows = Math.min(smallestMaximumCows, maxAreaCow);
            }
        }

        sb.append(smallestMaximumCows);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int rangeSum(int[][] pSums, int sx, int sy, int ex, int ey) {
        return pSums[ex][ey] - pSums[ex][sy] - pSums[sx][ey] + pSums[sx][sy];
    }
}
