import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String password = br.readLine() + "ILOVEYONSEI";

        int minMoveCnt = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            char cur = password.charAt(i);
            char next = password.charAt(i + 1);

            minMoveCnt += Math.abs(next - cur);
        }
        sb.append(minMoveCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
