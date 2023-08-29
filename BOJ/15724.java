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
        int[][] livingPersonCnt = new int[rowSize + 1][colSize + 1];
        for (int row = 1; row <= rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= colSize; col++) {
                int livingPerson = Integer.parseInt(st.nextToken());
                livingPersonCnt[row][col] = livingPersonCnt[row - 1][col] + livingPersonCnt[row][col - 1] - livingPersonCnt[row - 1][col - 1] + livingPerson;
            }
        }
        int queryCnt = Integer.parseInt(br.readLine());
        for (int query = 0; query < queryCnt; query++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(livingPersonCnt[x2][y2] - livingPersonCnt[x2][y1 - 1] - livingPersonCnt[x1 - 1][y2] + livingPersonCnt[x1 - 1][y1 - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
