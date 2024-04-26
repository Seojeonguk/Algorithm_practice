import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final String DIRECTION = "EWSN";
    static final int EAST = 0;
    static final int WEST = 1;
    static final int SOUTH = 2;
    static final int NORTH = 3;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int rounds = Integer.parseInt(st.nextToken());

            int[][] games = new int[rowSize + 1][colSize + 1];
            boolean[][] isFallDown = new boolean[rowSize + 1][colSize + 1];

            for (int row = 1; row <= rowSize; row++) {
                StringTokenizer rows = new StringTokenizer(br.readLine());
                for (int col = 1; col <= colSize; col++) {
                    games[row][col] = Integer.parseInt(rows.nextToken());
                }
            }

            int score = 0;
            for (int round = 0; round < rounds; round++) {
                StringTokenizer roundInfo = new StringTokenizer(br.readLine());
                int startRow = Integer.parseInt(roundInfo.nextToken());
                int startCol = Integer.parseInt(roundInfo.nextToken());
                char direction = roundInfo.nextToken().charAt(0);

                score += calFallDown(rowSize, colSize, games, isFallDown, startRow, startCol, direction);

                StringTokenizer standInfo = new StringTokenizer(br.readLine());
                int standRow = Integer.parseInt(standInfo.nextToken());
                int standCol = Integer.parseInt(standInfo.nextToken());
                isFallDown[standRow][standCol] = false;
            }

            sb.append(score).append("\n");
            for (int row = 1; row <= rowSize; row++) {
                for (int col = 1; col <= colSize; col++) {
                    sb.append(isFallDown[row][col] ? 'F' : 'S').append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int calFallDown(int rowSize, int colSize, int[][] games, boolean[][] isFallDown, int row, int col, char direction) {
        int dir = convertDirection(direction);

        int[][] range = {{row, row}, {col, col}};

        int score = 0;
        while (!isRangeOut(range, row, col)) {
            if (!isFallDown[row][col]) {
                if (dir == EAST) {
                    range[1][1] = Math.min(colSize, Math.max(range[1][1], col + games[row][col] - 1));
                } else if (dir == WEST) {
                    range[1][0] = Math.max(1, Math.min(range[1][0], col - games[row][col] + 1));
                } else if (dir == SOUTH) {
                    range[0][1] = Math.min(rowSize, Math.max(range[0][1], row + games[row][col] - 1));
                } else if (dir == NORTH) {
                    range[0][0] = Math.max(1, Math.min(range[0][0], row - games[row][col] + 1));
                }

                isFallDown[row][col] = true;
                score++;
            }

            row += DIRS[dir][0];
            col += DIRS[dir][1];
        }

        return score;
    }

    public static int convertDirection(char direction) {
        return DIRECTION.indexOf(direction);
    }

    public static boolean isRangeOut(int[][] range, int x, int y) {
        return (range[0][0] > x || range[0][1] < x || range[1][0] > y || range[1][1] < y);
    }
}
