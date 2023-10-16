import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int screenWidth = Integer.parseInt(st.nextToken());
        int basketWidth = Integer.parseInt(st.nextToken());
        int basketStartPlace = 1;

        int minBasketMovedDistance = 0;

        int droppedAppleCnt = Integer.parseInt(br.readLine());
        while (droppedAppleCnt-- > 0) {
            int droppedApplePlace = Integer.parseInt(br.readLine());
            if (droppedApplePlace < basketStartPlace) {
                minBasketMovedDistance += basketStartPlace - droppedApplePlace;
                basketStartPlace = droppedApplePlace;
            } else if (droppedApplePlace > basketStartPlace + basketWidth - 1) {
                minBasketMovedDistance += droppedApplePlace - (basketStartPlace + basketWidth - 1);
                basketStartPlace = droppedApplePlace - basketWidth + 1;
            }
        }
        sb.append(minBasketMovedDistance);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
