import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long aPointX = Long.parseLong(st.nextToken());
        long aPointY = Long.parseLong(st.nextToken());
        long aPointR = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long bPointX = Long.parseLong(st.nextToken());
        long bPointY = Long.parseLong(st.nextToken());
        long bPointR = Long.parseLong(st.nextToken());

        long diffX = Math.abs(aPointX - bPointX);
        long diffY = Math.abs(aPointY - bPointY);

        long centerDiff = diffX * diffX + diffY * diffY;
        long maxR = aPointR + bPointR;

        sb.append(maxR * maxR > centerDiff ? "YES" : "NO");


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
