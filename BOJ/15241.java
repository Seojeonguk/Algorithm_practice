import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        char[][] pastures = new char[rowSize + 1][colSize + 1];
        int[][] possiblePaths = new int[rowSize + 1][colSize + 1];

        for (int row = 1; row <= rowSize; row++) {
            System.arraycopy(br.readLine().toCharArray(), 0, pastures[row], 1, colSize);
            for (int col = 1; col <= colSize; col++) {
                if (pastures[row][col] == 'X') {
                    continue;
                }
                possiblePaths[row][col] = (row == 1 && col == 1 ? 1 : (possiblePaths[row - 1][col] + possiblePaths[row][col - 1]) % MOD);
            }
        }
        sb.append(possiblePaths[rowSize][colSize]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
