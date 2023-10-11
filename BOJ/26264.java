import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int studentNum = Integer.parseInt(br.readLine());
        String answer = br.readLine();
        int idx = 0;
        int bigdata = 0, security = 0;
        while (idx < answer.length()) {
            if (answer.charAt(idx) == 's') {
                idx += 8;
                security++;
            } else {
                idx += 7;
                bigdata++;
            }
        }
        if (bigdata >= security) {
            sb.append("bigdata? ");
        }
        if (bigdata <= security) {
            sb.append("security!");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
