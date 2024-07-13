import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final char[][] SHAPES = {{'#', '#', '#'}, {'#', '.', '.'}, {'#', '#', '#'}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer sizes = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(sizes.nextToken());
            int colSize = Integer.parseInt(sizes.nextToken());

            StringTokenizer flipCosts = new StringTokenizer(br.readLine());
            int flipWhiteCost = Integer.parseInt(flipCosts.nextToken());
            int flipBlackCost = Integer.parseInt(flipCosts.nextToken());

            char[][] colors = new char[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                colors[row] = br.readLine().toCharArray();
            }

            int minCost = Integer.MAX_VALUE;
            for (int shapeSize = 1; shapeSize * 3 <= rowSize && shapeSize * 3 <= colSize; shapeSize++) {
                int limitRow = rowSize - shapeSize * 3;
                int limitCol = colSize - shapeSize * 3;

                for (int row = 0; row <= limitRow; row++) {
                    for (int col = 0; col <= limitCol; col++) {
                        int cost = calCost(rowSize, colSize, row, col, colors, shapeSize, flipWhiteCost, flipBlackCost);
                        minCost = Math.min(minCost, cost);
                    }
                }
            }

            sb.append(minCost);

            bw.write(sb.toString());
        }
    }

    public static int calCost(int rowSize, int colSize, int startRow, int startCol, char[][] colors, int shapeSize, int flipWhiteCost, int flipBlackCost) {
        char[][] targets = new char[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            Arrays.fill(targets[row], '.');
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int addedRow = 0; addedRow < shapeSize; addedRow++) {
                    for (int addedCol = 0; addedCol < shapeSize; addedCol++) {
                        int row = startRow + i * shapeSize + addedRow;
                        int col = startCol + j * shapeSize + addedCol;

                        targets[row][col] = SHAPES[i][j];
                    }
                }
            }
        }

        int cost = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (targets[row][col] == colors[row][col]) {
                    continue;
                }

                cost += (colors[row][col] == '#' ? flipBlackCost : flipWhiteCost);
            }
        }

        return cost;
    }
}
