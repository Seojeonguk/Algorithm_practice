import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int destinationX = Integer.parseInt(st.nextToken());
        int destinationY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int initialCharging = Integer.parseInt(st.nextToken());
        
        int distanceX = Math.abs(startX - destinationX);
        int distanceY = Math.abs(startY - destinationY);
        if (distanceX + distanceY <= initialCharging && (distanceX + distanceY) % 2 == initialCharging % 2) {
            sb.append("Y");
        } else {
            sb.append("N");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
