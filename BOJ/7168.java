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

        char[][] puzzles = new char[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            puzzles[row] = br.readLine().toCharArray();

            boolean isFind = false;
            int rowCnt = 0;
            for (int col = 0; col < colSize; col++) {
                if (puzzles[row][col] == '.') {
                    if (rowCnt > 0) {
                        sb.append(rowCnt).append(" ");
                    }
                    rowCnt = 0;
                } else {
                    rowCnt++;
                    isFind = true;
                }
            }
            if (rowCnt > 0) {
                sb.append(rowCnt).append(" ");
            }
            if (!isFind) {
                sb.append(0);
            }
            sb.append("\n");
        }

        for (int col = 0; col < colSize; col++) {
            int colCnt = 0;
            boolean isFind = false;
            for (int row = 0; row < rowSize; row++) {
                if (puzzles[row][col] == '.') {
                    if (colCnt > 0) {
                        sb.append(colCnt).append(" ");
                    }
                    colCnt = 0;
                } else {
                    colCnt++;
                    isFind = true;
                }
            }
            if (colCnt > 0) {
                sb.append(colCnt).append(" ");
            }
            if (!isFind) {
                sb.append(0);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
