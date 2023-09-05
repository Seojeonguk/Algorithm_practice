import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int signSize = Integer.parseInt(br.readLine());
        char[][] sign = new char[signSize][signSize];
        for (int row = 0; row < signSize; row++) {
            Arrays.fill(sign[row], ' ');
        }

        for (int x = 0, idx = 0; x < signSize; x++, idx++) {
            sign[x][0] = sign[x][signSize - 1] = '*';
            sign[x][idx] = sign[x][signSize - 1 - idx] = '*';
            sign[0][x] = sign[signSize - 1][x] = '*';
        }

        for (int row = 0; row < signSize; row++) {
            sb.append(sign[row]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
