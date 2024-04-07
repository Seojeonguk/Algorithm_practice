import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static final int MAX_VALUE = 12;
    static final int ROW_SIZE = 5;
    static final int COL_SIZE = 9;
    static final int MAGIC_STAR_SUM = 26;
    static boolean isFound = false;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] grid = new char[ROW_SIZE][COL_SIZE];
        int[] magicStars = new int[MAX_VALUE];
        boolean[] appeared = new boolean[MAX_VALUE + 1];
        ArrayList<Integer> emptyCells = new ArrayList<>();
        int magicStarIdx = 0;

        for (int row = 0; row < ROW_SIZE; row++) {
            grid[row] = br.readLine().toCharArray();
            for (int col = 0; col < COL_SIZE; col++) {
                if (grid[row][col] == '.') {
                    continue;
                }

                if (grid[row][col] == 'x') {
                    emptyCells.add(magicStarIdx);
                    magicStars[magicStarIdx++] = -1;
                } else {
                    int alphabetIdx = grid[row][col] - 'A';
                    appeared[alphabetIdx] = true;
                    magicStars[magicStarIdx++] = alphabetIdx;
                }
            }
        }

        solve(magicStars, appeared, emptyCells, 0);

        magicStarIdx = 0;
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                if (grid[row][col] == '.') {
                    sb.append('.');
                } else {
                    sb.append((char) ('A' + magicStars[magicStarIdx++]));
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int[] magicStars, boolean[] appeared, ArrayList<Integer> emptyCells, int valueIdx) {
        if (valueIdx == emptyCells.size()) {
            if (isMagicStar(magicStars)) {
                isFound = true;
            }
            return;
        }

        for (int i = 0; i < MAX_VALUE; i++) {
            if (appeared[i]) {
                continue;
            }

            int emptyMagicStarIdx = emptyCells.get(valueIdx);

            appeared[i] = true;
            magicStars[emptyMagicStarIdx] = i;
            solve(magicStars, appeared, emptyCells, valueIdx + 1);
            if (isFound) {
                return;
            }

            magicStars[emptyMagicStarIdx] = -1;
            appeared[i] = false;
        }
    }

    public static boolean isMagicStar(int[] magicStars) {
        return (magicStars[0] + magicStars[2] + magicStars[5] + magicStars[7] == MAGIC_STAR_SUM - 4) &&
                (magicStars[0] + magicStars[3] + magicStars[6] + magicStars[10] == MAGIC_STAR_SUM - 4) &&
                (magicStars[7] + magicStars[8] + magicStars[9] + magicStars[10] == MAGIC_STAR_SUM - 4) &&
                (magicStars[1] + magicStars[2] + magicStars[3] + magicStars[4] == MAGIC_STAR_SUM - 4) &&
                (magicStars[1] + magicStars[5] + magicStars[8] + magicStars[11] == MAGIC_STAR_SUM - 4) &&
                (magicStars[4] + magicStars[6] + magicStars[9] + magicStars[11] == MAGIC_STAR_SUM - 4);
    }
}
