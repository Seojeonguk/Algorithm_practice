import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int stationCnt = Integer.parseInt(br.readLine());

        int bottomX = Integer.MAX_VALUE, bottomY = Integer.MAX_VALUE;
        while (stationCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (bottomY > y) {
                bottomX = x;
                bottomY = y;
            }
        }

        sb.append(bottomX).append(" ").append(bottomY);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
