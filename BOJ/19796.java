import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int boardCnt = Integer.parseInt(st.nextToken());
        int observedCnt = Integer.parseInt(st.nextToken());

        boolean[] board = new boolean[boardCnt + 1];
        int boarded = 0;
        while (observedCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int i = a; i <= b; i++) {
                if (!board[i]) {
                    boarded++;
                    board[i] = true;
                }
            }
        }

        sb.append(boarded == boardCnt ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
