import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            long participantCnt = Long.parseLong(st.nextToken());
            int productCnt = Integer.parseInt(st.nextToken());
            long hasMoney = Long.parseLong(st.nextToken());

            StringTokenizer costs = new StringTokenizer(br.readLine());
            long[] productCosts = new long[productCnt];
            for (int i = 0; i < productCnt; i++) {
                productCosts[i] = Long.parseLong(costs.nextToken());
            }

            long[] requiredProducts = new long[productCnt];
            requiredProducts[productCnt - 1] = participantCnt;

            long sumMoney = 0;

            for (int i = 0; i < productCnt - 1; i++) {
                long left = 0, right = requiredProducts[productCnt - 1];
                while (left < right) {
                    long mid = (left + right) / 2;

                    long money = sumMoney + mid * productCosts[i] + (requiredProducts[productCnt - 1] - mid) * productCosts[productCnt - 1];
                    if (money < hasMoney) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                long money = sumMoney + left * productCosts[i] + (requiredProducts[productCnt - 1] - left) * productCosts[productCnt - 1];
                if (money > hasMoney) {
                    left--;
                }

                requiredProducts[i] = left;
                requiredProducts[productCnt - 1] -= requiredProducts[i];
                sumMoney += requiredProducts[i] * productCosts[i];
            }

            for (int i = 0; i < productCnt; i++) {
                sb.append(requiredProducts[i]).append(" ");
            }


            bw.write(sb.toString());
        }
    }
}
