import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int PRICE_CNT = 3;
    static final int COUPON_CNT = 3;

    public static void main(String[] args) throws Exception {
        int[] prices = new int[3];
        int[] coupons = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < PRICE_CNT; idx++) {
            prices[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(prices);

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < COUPON_CNT; idx++) {
            coupons[idx] = Integer.parseInt(st.nextToken());
        }
        double entireDiscount = (double) 1.0f * (prices[0] + prices[1] + prices[2]) * coupons[0] / 100;
        double twoItemDiscount = (1.0f * prices[2] * Math.max(coupons[1], coupons[2]) / 100) + (1.0f * prices[1] * Math.min(coupons[1], coupons[2]) / 100);

        if (entireDiscount > twoItemDiscount) {
            sb.append(String.format("one %.2f\n", entireDiscount));
        } else {
            sb.append(String.format("two %.2f\n", twoItemDiscount));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
