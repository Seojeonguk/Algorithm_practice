import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int diffHeight = Integer.parseInt(st.nextToken());

            int[][] heights = new int[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                StringTokenizer rows = new StringTokenizer(br.readLine());
                for (int col = 0; col < colSize; col++) {
                    heights[row][col] = Integer.parseInt(rows.nextToken());
                }
            }

            sb.append(canSeat(rowSize, colSize, diffHeight, heights) ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }

    public static boolean canSeat(int rowSize, int colSize, int diffHeight, int[][] heights) {
        for (int row = 0; row < rowSize; row++) {
            Arrays.sort(heights[row]);
        }

        for (int col = 0; col < colSize; col++) {
            for (int row = 1; row < rowSize; row++) {
                int frontHeight = diffHeight * (row - 1) + heights[row - 1][col];
                int currentHeight = diffHeight * row + heights[row][col];

                if (frontHeight >= currentHeight) {
                    return false;
                }
            }
        }

        return true;
    }
}
