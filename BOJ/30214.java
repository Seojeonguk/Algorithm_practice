import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int halfSolving = Integer.parseInt(st.nextToken());
        int finishSolving = Integer.parseInt(st.nextToken());
        sb.append((finishSolving + 1) / 2 <= halfSolving ? "E" : "H");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
