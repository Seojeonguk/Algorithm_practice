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

        StringTokenizer fishingInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(fishingInfo.nextToken());
        int colSize = Integer.parseInt(fishingInfo.nextToken());
        int throwFishingRodCnt = Integer.parseInt(fishingInfo.nextToken());

        int[][] fishes = new int[rowSize + 1][colSize + 1];
        int[][] prefixSums = new int[rowSize + 1][colSize + 1];

        for (int row = 1; row <= rowSize; row++) {
            StringTokenizer fishesInfo = new StringTokenizer(br.readLine());
            for (int col = 1; col <= colSize; col++) {
                fishes[row][col] = Integer.parseInt(fishesInfo.nextToken());
                prefixSums[row][col] = fishes[row][col] + prefixSums[row - 1][col - 1] + prefixSums[row - 1][col] - (row >= 2 ? prefixSums[row - 2][col - 1] : 0);
            }
        }

        for (int throwFishingRodNum = 0; throwFishingRodNum < throwFishingRodCnt; throwFishingRodNum++) {
            StringTokenizer throwInfo = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(throwInfo.nextToken());
            int power = Integer.parseInt(throwInfo.nextToken());

            sb.append(prefixSums[weight][power]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
