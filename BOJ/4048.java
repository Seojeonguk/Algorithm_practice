import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; ; tc++) {
            StringTokenizer gridInfo = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(gridInfo.nextToken());
            int colSize = Integer.parseInt(gridInfo.nextToken());

            if (rowSize == 0 && colSize == 0) {
                break;
            }

            int[][] grid = new int[rowSize + 2][colSize + 2];
            int maxHeight = 0;
            for (int row = 1; row <= rowSize; row++) {
                StringTokenizer heightInfo = new StringTokenizer(br.readLine());
                for (int col = 1; col <= colSize; col++) {
                    grid[row][col] = Integer.parseInt(heightInfo.nextToken());
                    maxHeight = Math.max(maxHeight, grid[row][col]);
                }
            }

            int divideHeight = calDivideIsland(rowSize, colSize, grid, maxHeight);
            sb.append("Case ").append(tc).append(": ");
            if (divideHeight < 0) {
                sb.append("Island never splits.\n");
            } else {
                sb.append("Island splits when ocean rises ").append(divideHeight).append(" feet.\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calDivideIsland(int rowSize, int colSize, int[][] grid, int maxHeight) {
        boolean[][] isVisit = new boolean[rowSize + 2][colSize + 2];

        for (int height = 0; height < maxHeight; height++) {
            init(isVisit);
            flowWater(grid, isVisit, height);
            int islandCnt = calIslandCnt(grid, isVisit, height);

            if (islandCnt > 1) {
                return height;
            }
        }

        return -1;
    }

    private static int calIslandCnt(int[][] grid, boolean[][] isVisit, int height) {
        int islandCnt = 0;

        for (int row = 1; row <= grid.length - 1; row++) {
            for (int col = 1; col <= grid[0].length - 1; col++) {
                if (isVisit[row][col]) {
                    continue;
                }

                islandCnt++;
                isVisit[row][col] = true;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{row, col});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int idx = 0; idx < DIRS.length; idx++) {
                        int nx = cur[0] + DIRS[idx][0];
                        int ny = cur[1] + DIRS[idx][1];

                        if (isOut(grid.length, grid[0].length, nx, ny) || isVisit[nx][ny]) {
                            continue;
                        }

                        isVisit[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return islandCnt;
    }

    private static void flowWater(int[][] grid, boolean[][] isVisit, int height) {
        Queue<int[]> q = new LinkedList<>();
        isVisit[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int idx = 0; idx < DIRS.length; idx++) {
                int nx = cur[0] + DIRS[idx][0];
                int ny = cur[1] + DIRS[idx][1];

                if (isOut(grid.length, grid[0].length, nx, ny) || isVisit[nx][ny] || grid[nx][ny] > height) {
                    continue;
                }

                isVisit[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void init(boolean[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            Arrays.fill(arr[row], false);
        }
    }

    public static boolean isOut(int rowSize, int colSize, int n, int m) {
        return (n < 0 || m < 0 || n >= rowSize || m >= colSize);
    }
}
