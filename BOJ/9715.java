import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer size = new StringTokenizer(br.readLine());
                int rowSize = Integer.parseInt(size.nextToken());
                int colSize = Integer.parseInt(size.nextToken());

                char[][] heights = new char[rowSize + 2][colSize + 2];
                for (int row = 0; row < rowSize + 2; row++) {
                    Arrays.fill(heights[row], '0');
                }

                for (int row = 1; row <= rowSize; row++) {
                    char[] rows = br.readLine().toCharArray();

                    System.arraycopy(rows, 0, heights[row], 1, rows.length);
                }

                int totalSurface = getSurface(heights);
                sb.append(totalSurface).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int getSurface(char[][] heights) {
        int surface = 0;
        for (int row = 1; row < heights.length - 1; row++) {
            for (int col = 1; col < heights[row].length - 1; col++) {
                if (heights[row][col] != '0') {
                    surface += 2;
                }

                for (int[] directions : DIRECTIONS) {
                    char a = heights[row][col];
                    char b = heights[row + directions[0]][col + directions[1]];
                    if (a > b) {
                        surface += Math.abs(heights[row][col] - heights[row + directions[0]][col + directions[1]]);
                    }
                }
            }
        }

        return surface;
    }
}
