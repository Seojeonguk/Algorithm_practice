import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int yt = Integer.parseInt(st.nextToken());
        int yj = Integer.parseInt(st.nextToken());

        boolean turn = true;
        while (yt < 5 && yj < 5) {
            if (turn) yj += yt;
            else yt += yj;
            turn = !turn;
        }

        if (yt >= 5) sb.append("yj");
        else sb.append("yt");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
