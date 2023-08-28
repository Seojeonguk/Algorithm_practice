import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            char[][] box = new char[rowSize][colSize];
            int candyCnt = 0;
            for (int row = 0; row < rowSize; row++) {
                box[row] = br.readLine().toCharArray();
                for (int col = 0; col < colSize - 2; col++) {
                    if (box[row][col] == '>' && box[row][col + 1] == 'o' && box[row][col + 2] == '<') {
                        candyCnt++;
                    }
                }
                if (row >= 2) {
                    for (int col = 0; col < colSize; col++) {
                        if (box[row - 2][col] == 'v' && box[row - 1][col] == 'o' && box[row][col] == '^') {
                            candyCnt++;
                        }
                    }
                }
            }
            sb.append(candyCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
