import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static final int LIMIT_MONEY = 300;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                int soldSnackCnt = Integer.parseInt(br.readLine());
                if (soldSnackCnt == 0) {
                    break;
                }

                int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                sb.append(spendMoneys(prices)).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int spendMoneys(int[] prices) {
        int spendMoney = 0;

        for (int price : prices) {
            if (spendMoney + price <= LIMIT_MONEY) {
                spendMoney += price;
            }
        }


        return spendMoney;
    }
}
