import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String board = br.readLine();
        int idx = 0;
        while (idx < board.length()) {
            if (board.charAt(idx) == '.') {
                sb.append(".");
                idx++;
            } else {
                int xCnt = 0;
                for (int i = idx; i < board.length() && board.charAt(i) != '.'; i++) {
                    xCnt++;
                }
                if (xCnt % 2 != 0) {
                    sb = new StringBuilder("-1");
                    break;
                } else {
                    idx += xCnt;
                    while (xCnt >= 4) {
                        sb.append("AAAA");
                        xCnt -= 4;
                    }
                    while (xCnt >= 2) {
                        sb.append("BB");
                        xCnt -= 2;
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
