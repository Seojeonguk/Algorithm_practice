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
            int deliveryCnt = Integer.parseInt(st.nextToken());
            int orderCnt = Integer.parseInt(st.nextToken());

            int[] gains = new int[deliveryCnt];
            int[] lastOrderTimes = new int[deliveryCnt];

            for (int orderNum = 0; orderNum < orderCnt; orderNum++) {
                StringTokenizer orders = new StringTokenizer(br.readLine());
                int orderTime = Integer.parseInt(orders.nextToken());
                int gain = Integer.parseInt(orders.nextToken());

                int deliveryNum = -1;
                int minDeliveryTime = Integer.MAX_VALUE;
                for (int i = 0; i < deliveryCnt; i++) {
                    int deliveryTime = Integer.parseInt(orders.nextToken());
                    if (lastOrderTimes[i] > orderTime) {
                        continue;
                    }

                    if (minDeliveryTime > deliveryTime) {
                        minDeliveryTime = deliveryTime;
                        deliveryNum = i;
                    }
                }

                if (deliveryNum == -1) {
                    continue;
                }

                lastOrderTimes[deliveryNum] = orderTime + minDeliveryTime;
                gains[deliveryNum] += gain;
            }

            for (int gain : gains) {
                sb.append(gain).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
