import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int PRODUCT_CNT = 3;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String[] prices = new String[PRODUCT_CNT];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < PRODUCT_CNT; i++) {
                prices[i] = st.nextToken();
            }

            sb.append(prices[0]);
            for (int i = 1; i < PRODUCT_CNT; i++) {
                if (prices[i - 1].charAt(prices[i - 1].length() - 1) == prices[i].charAt(0)) {
                    sb.append("'");
                    sb.append(prices[i], 1, prices[i].length());
                } else {
                    sb.append(prices[i]);
                }
            }

            bw.write(sb.toString());
        }
    }
}
