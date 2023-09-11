import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String LOGO = "DKSH";

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        int existCnt = 0;
        for (int idx = 0; idx < str.length() - 3; idx++) {
            if (str.startsWith(LOGO, idx)) {
                existCnt++;
            }
        }
        sb.append(existCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
