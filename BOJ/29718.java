import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int[][] seats = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                seats[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        int[] claps = new int[colSize];
        for (int col = 0; col < colSize; col++) {
            int clap = 0;
            for (int row = 0; row < rowSize; row++) {
                clap += seats[row][col];
            }
            claps[col] = clap + (col > 0 ? claps[col - 1] : 0);
        }
        int continuousCol = Integer.parseInt(br.readLine());
        int maxClaps = claps[continuousCol - 1];
        for (int col = continuousCol; col < colSize; col++) {
            maxClaps = Math.max(maxClaps, claps[col] - claps[col - continuousCol]);
        }
        sb.append(maxClaps);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
