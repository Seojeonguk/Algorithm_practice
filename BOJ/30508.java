import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer crosswalkInfo = new StringTokenizer(br.readLine());
        int crosswalkRowSize = Integer.parseInt(crosswalkInfo.nextToken());
        int crosswalkColSize = Integer.parseInt(crosswalkInfo.nextToken());

        StringTokenizer shoesInfo = new StringTokenizer(br.readLine());
        int shoesRowSize = Integer.parseInt(shoesInfo.nextToken());
        int shoesColSize = Integer.parseInt(shoesInfo.nextToken());

        int[][] crosswalkWaterHeights = new int[crosswalkRowSize + 1][crosswalkColSize + 1];
        for (int crosswalkRowNum = 1; crosswalkRowNum <= crosswalkRowSize; crosswalkRowNum++) {
            StringTokenizer crosswalkRowInfo = new StringTokenizer(br.readLine());
            for (int crosswalkColNum = 1; crosswalkColNum <= crosswalkColSize; crosswalkColNum++) {
                crosswalkWaterHeights[crosswalkRowNum][crosswalkColNum] = Integer.parseInt(crosswalkRowInfo.nextToken());
            }
        }

        Queue<int[]> isNotFilledWaterCoordinates = new LinkedList<>();

        boolean[][] isNotFilledWaters = new boolean[crosswalkRowSize + 1][crosswalkColSize + 1];
        int sewerCnt = Integer.parseInt(br.readLine());
        for (int sewerNum = 0; sewerNum < sewerCnt; sewerNum++) {
            StringTokenizer sewerInfo = new StringTokenizer(br.readLine());
            int sewerX = Integer.parseInt(sewerInfo.nextToken());
            int sewerY = Integer.parseInt(sewerInfo.nextToken());

            isNotFilledWaters[sewerX][sewerY] = true;
            isNotFilledWaterCoordinates.add(new int[]{sewerX, sewerY});
        }

        while (!isNotFilledWaterCoordinates.isEmpty()) {
            int[] isNotFilledWaterCoordinate = isNotFilledWaterCoordinates.poll();
            int curX = isNotFilledWaterCoordinate[0];
            int curY = isNotFilledWaterCoordinate[1];

            for (int dir = 0; dir < DIRS.length; dir++) {
                int nx = curX + DIRS[dir][0];
                int ny = curY + DIRS[dir][1];

                if (isOut(crosswalkRowSize, crosswalkColSize, nx, ny) || isNotFilledWaters[nx][ny] || crosswalkWaterHeights[curX][curY] > crosswalkWaterHeights[nx][ny]) {
                    continue;
                }
                isNotFilledWaters[nx][ny] = true;
                isNotFilledWaterCoordinates.add(new int[]{nx, ny});
            }
        }

        int[][] prefixSums = new int[crosswalkRowSize + 1][crosswalkColSize + 1];
        int canStepCnt = 0;
        for (int row = 1; row <= crosswalkRowSize; row++) {
            for (int col = 1; col <= crosswalkColSize; col++) {
                prefixSums[row][col] = (isNotFilledWaters[row][col] ? 1 : 0) + prefixSums[row - 1][col] + prefixSums[row][col - 1] - prefixSums[row - 1][col - 1];

                if (row >= shoesRowSize && col >= shoesColSize) {
                    int isNotFilledWaterCnt = prefixSums[row][col] - prefixSums[row - shoesRowSize][col] - prefixSums[row][col - shoesColSize] + prefixSums[row - shoesRowSize][col - shoesColSize];
                    if (isNotFilledWaterCnt == shoesRowSize * shoesColSize) {
                        canStepCnt++;
                    }
                }
            }
        }
        sb.append(canStepCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 1 || y < 1 || x > rowSize || y > colSize);
    }
}
