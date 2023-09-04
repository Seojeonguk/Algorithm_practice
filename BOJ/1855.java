import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int colSize = Integer.parseInt(br.readLine());
        String encrypted = br.readLine();

        char[][] table = new char[encrypted.length() / colSize][colSize];
        int x = 0, y = 0;
        for (int idx = 0; idx < encrypted.length(); idx++) {
            table[x][y] = encrypted.charAt(idx);
            int remainder = idx % colSize;
            int row = idx / colSize;
            if (remainder == colSize - 1) {
                x++;
            } else {
                if (row % 2 == 0) {
                    y++;
                } else {
                    y--;
                }
            }
        }

        for (int col = 0; col < colSize; col++) {
            for (int row = 0; row < encrypted.length() / colSize; row++) {
                sb.append(table[row][col]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
