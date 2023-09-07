import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int gridSize = Integer.parseInt(br.readLine());
        int[][] grid = new int[gridSize][gridSize];

        for (int row = 0; row < gridSize; row++) {
            String rowState = br.readLine();
            for (int col = 0; col < gridSize; col++) {
                grid[row][col] = rowState.charAt(col) - '0';
            }
        }

        int flipCnt = 0;
        for (int row = gridSize - 1; row >= 0; row--) {
            for (int col = gridSize - 1; col >= 0; col--) {
                if (grid[row][col] == 1) {
                    flipCnt++;
                    for (int r = 0; r <= row; r++) {
                        for (int c = 0; c <= col; c++) {
                            grid[r][c] = 1 - grid[r][c];
                        }
                    }
                }
            }
        }
        sb.append(flipCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
