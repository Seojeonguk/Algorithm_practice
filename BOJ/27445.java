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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());

            int[][] dist = new int[rowSize + 1][colSize + 1];
            dist[0][1] = dist[rowSize][0] = Integer.MAX_VALUE;
            for (int row = 1; row < rowSize; row++) {
                dist[row][1] = Integer.parseInt(br.readLine());
            }

            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= colSize; col++) {
                dist[rowSize][col] = Integer.parseInt(st.nextToken());
            }

            int hideRow = 0;
            for (int row = 1; row <= rowSize; row++) {
                if (dist[hideRow][1] > dist[row][1]) {
                    hideRow = row;
                }
            }

            int hideCol = 0;
            for (int col = 1; col <= colSize; col++) {
                if (dist[rowSize][hideCol] > dist[rowSize][col]) {
                    hideCol = col;
                }
            }

            sb.append(hideRow).append(" ").append(hideCol);

            bw.write(sb.toString());
        }
    }
}
