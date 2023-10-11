import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] today = br.readLine().split("-");
        int todayYear = Integer.parseInt(today[0]);
        int todayMonth = Integer.parseInt(today[1]);
        int todayDay = Integer.parseInt(today[2]);

        int gifticonCnt = Integer.parseInt(br.readLine());
        int possibleUseGifticonCnt = 0;

        for (int gifticon = 0; gifticon < gifticonCnt; gifticon++) {
            String[] expiration = br.readLine().split("-");
            int expirationYear = Integer.parseInt(expiration[0]);
            int expirationMonth = Integer.parseInt(expiration[1]);
            int expirationDay = Integer.parseInt(expiration[2]);

            if (todayYear < expirationYear) {
                possibleUseGifticonCnt++;
            } else if (todayYear == expirationYear) {
                if (todayMonth < expirationMonth) {
                    possibleUseGifticonCnt++;
                } else if (todayMonth == expirationMonth) {
                    if (todayDay <= expirationDay) {
                        possibleUseGifticonCnt++;
                    }
                }
            }
        }

        sb.append(possibleUseGifticonCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
