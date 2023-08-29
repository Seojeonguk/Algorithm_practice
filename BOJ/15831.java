import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int pebbleCnt = Integer.parseInt(st.nextToken());
        int maxBlackPebbleCnt = Integer.parseInt(st.nextToken());
        int minWhitePebbleCnt = Integer.parseInt(st.nextToken());

        String pebbles = br.readLine();
        int left = 0;
        int maxLength = 0;
        int currentBlackPebble = 0;
        int currentWhitePebble = 0;
        for (int right = 0; right < pebbles.length(); right++) {
            if (pebbles.charAt(right) == 'W') {
                currentWhitePebble++;
            } else {
                currentBlackPebble++;
            }
            while (left < right && currentBlackPebble > maxBlackPebbleCnt) {
                if (pebbles.charAt(left) == 'W') {
                    currentWhitePebble--;
                } else {
                    currentBlackPebble--;
                }
                left++;
            }
            if (maxBlackPebbleCnt >= currentBlackPebble && minWhitePebbleCnt <= currentWhitePebble) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        sb.append(maxLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
