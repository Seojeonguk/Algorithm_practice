import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final char[] LAY_OF_LAND = {'J', 'O', 'I'};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer mapInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(mapInfo.nextToken());
        int colSize = Integer.parseInt(mapInfo.nextToken());

        int queryCnt = Integer.parseInt(br.readLine());

        int[][][] prefixSums = new int[rowSize + 1][colSize + 1][3];
        for (int row = 1; row <= rowSize; row++) {
            char[] mapRow = br.readLine().toCharArray();
            for (int col = 1; col <= colSize; col++) {
                for (int land = 0; land < LAY_OF_LAND.length; land++) {
                    prefixSums[row][col][land] += prefixSums[row - 1][col][land] + prefixSums[row][col - 1][land] - prefixSums[row - 1][col - 1][land];
                }
                int landIdx = convertSearchToIdx(mapRow[col - 1]);
                prefixSums[row][col][landIdx]++;
            }
        }

        for (int query = 0; query < queryCnt; query++) {
            StringTokenizer searchArea = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(searchArea.nextToken());
            int b = Integer.parseInt(searchArea.nextToken());
            int c = Integer.parseInt(searchArea.nextToken());
            int d = Integer.parseInt(searchArea.nextToken());

            for (int land = 0; land < LAY_OF_LAND.length; land++) {
                sb.append(prefixSums[c][d][land] - prefixSums[a - 1][d][land] - prefixSums[c][b - 1][land] + prefixSums[a - 1][b - 1][land]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int convertSearchToIdx(char c) {
        for (int idx = 0; idx < LAY_OF_LAND.length; idx++) {
            if (LAY_OF_LAND[idx] == c) {
                return idx;
            }
        }
        return -1;
    }
}
