import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tigerCnt = 0, lionCnt = 0;

        for (int i = 0; i < 9; i++) {
            String vote = br.readLine();
            if ("Lion".equals(vote)) {
                lionCnt++;
            } else {
                tigerCnt++;
            }
        }
        sb.append(tigerCnt > lionCnt ? "Tiger" : "Lion");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
