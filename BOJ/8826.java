import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < tc; testCase++) {
            int moveCnt = Integer.parseInt(br.readLine());
            String moveDirection = br.readLine();

            int verticalMovedCnt = 0;
            int horizontalMovedCnt = 0;
            for (int i = 0; i < moveCnt; i++) {
                char dir = moveDirection.charAt(i);
                if (dir == 'E') horizontalMovedCnt++;
                else if (dir == 'W') horizontalMovedCnt--;

                if (dir == 'N') verticalMovedCnt++;
                else if (dir == 'S') verticalMovedCnt--;
            }
            sb.append(Math.abs(horizontalMovedCnt) + Math.abs(verticalMovedCnt)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
