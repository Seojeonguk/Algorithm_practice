import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int ENTRY_FEE = 4000;

    public static void main(String[] args) throws Exception {
        int teamCnt = Integer.parseInt(br.readLine());

        sb.append(teamCnt * ENTRY_FEE);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
