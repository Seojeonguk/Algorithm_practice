import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int shipStartX, shipStartY, shipEndX, shipEndY;

    public static void main(String[] args) throws Exception {
        int alienShipCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int BakhytzhanX = Integer.parseInt(st.nextToken()) + 10000;
        int BakhytzhanY = Integer.parseInt(st.nextToken()) + 10000;

        boolean isAlienShipLanded = false;
        for (int i = 0; i < alienShipCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int shipStartX = Integer.parseInt(st.nextToken()) + 10000;
            int shipStartY = Integer.parseInt(st.nextToken()) + 10000;
            int shipEndX = Integer.parseInt(st.nextToken()) + 10000;
            int shipEndY = Integer.parseInt(st.nextToken()) + 10000;

            isAlienShipLanded |= (shipStartX <= BakhytzhanX && BakhytzhanX <= shipEndX && shipStartY <= BakhytzhanY && BakhytzhanY <= shipEndY);
        }

        sb.append(isAlienShipLanded ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
