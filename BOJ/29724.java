import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int APPLE_SIZE = 12;
    final static int APPLE_BOX_WEIGHT = 1000;
    final static int APPLE_WEIGHT = 500;
    final static int PRICE_PER_APPLE = 4000;
    final static int PEAR_BOX_WEIGHT = 6000;

    public static void main(String[] args) throws Exception {
        int boxCnt = Integer.parseInt(br.readLine());
        int appleCnt = 0;
        int totalWeight = 0;
        while (boxCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int boxWidth = Integer.parseInt(st.nextToken());
            int boxHeight = Integer.parseInt(st.nextToken());
            int boxLength = Integer.parseInt(st.nextToken());

            if ("A".equals(fruit)) {
                appleCnt += (boxWidth / APPLE_SIZE) * (boxHeight / APPLE_SIZE) * (boxLength / APPLE_SIZE);
                totalWeight += APPLE_BOX_WEIGHT;
            } else {
                totalWeight += PEAR_BOX_WEIGHT;
            }
        }
        totalWeight += appleCnt * APPLE_WEIGHT;
        int totalPrice = appleCnt * PRICE_PER_APPLE;
        sb.append(totalWeight).append("\n").append(totalPrice);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
