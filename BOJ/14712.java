import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer gridInfo = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(gridInfo.nextToken());
            int colSize = Integer.parseInt(gridInfo.nextToken());

            boolean[][] grids = new boolean[rowSize][colSize];

            int possibleCnt = calPossibilities(grids, rowSize, colSize, 0);
            sb.append(possibleCnt);

            bw.write(sb.toString());
        }
    }

    public static int calPossibilities(boolean[][] grids, int rowSize, int colSize, int pos) {
        if (pos == rowSize * colSize) {
            return chk(grids, rowSize, colSize) ? 1 : 0;
        }

        int possibilities = calPossibilities(grids, rowSize, colSize, pos + 1);

        grids[pos / colSize][pos % colSize] = true;
        possibilities += calPossibilities(grids, rowSize, colSize, pos + 1);
        grids[pos / colSize][pos % colSize] = false;

        return possibilities;
    }

    public static boolean chk(boolean[][] grids, int rowSize, int colSize) {
        for (int row = 0; row < rowSize - 1; row++) {
            for (int col = 0; col < colSize - 1; col++) {
                if (grids[row][col] && grids[row + 1][col] && grids[row][col + 1] && grids[row + 1][col + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
