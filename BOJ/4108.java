import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final int[][] NEARS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws Exception {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());

            if (rowSize == 0 || colSize == 0) {
                break;
            }

            char[][] grid = new char[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                grid[row] = br.readLine().toCharArray();
            }

            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    if (grid[row][col] == '*') {
                        sb.append(grid[row][col]);
                    } else {
                        sb.append(findNearMine(grid, row, col));
                    }
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static int findNearMine(char[][] grid, int row, int col) {
        int nearMineCnt = 0;

        for (int[] near : NEARS) {
            int nearRow = row + near[0];
            int nearCol = col + near[1];

            if (isOut(nearRow, nearCol, grid.length, grid[0].length) || grid[nearRow][nearCol] == '.') {
                continue;
            }

            nearMineCnt++;
        }

        return nearMineCnt;
    }

    public static boolean isOut(int x, int y, int rowSize, int colSize) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }
}
