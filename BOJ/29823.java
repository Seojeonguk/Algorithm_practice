import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int stageCnt = Integer.parseInt(br.readLine());
        char[] stages = br.readLine().toCharArray();
        int horizontalMove = 0;
        int verticalMove = 0;
        for (int idx = 0; idx < stageCnt; idx++) {
            if (stages[idx] == 'N') {
                verticalMove++;
            } else if (stages[idx] == 'E') {
                horizontalMove++;
            } else if (stages[idx] == 'S') {
                verticalMove--;
            } else if (stages[idx] == 'W') {
                horizontalMove--;
            }
        }
        sb.append(Math.abs(verticalMove) + Math.abs(horizontalMove));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
