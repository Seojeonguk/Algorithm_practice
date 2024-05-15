import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int menuCnt = Integer.parseInt(br.readLine());
            int[] prices = new int[menuCnt];
            for (int menuNum = 0; menuNum < menuCnt; menuNum++) {
                prices[menuNum] = Integer.parseInt(br.readLine());
            }

            int fresherCnt = Integer.parseInt(br.readLine());

            int totalPrice = 0;
            for (int fresherNum = 0; fresherNum < fresherCnt; fresherNum++) {
                int menu = Integer.parseInt(br.readLine());

                totalPrice += prices[menu - 1];
            }

            sb.append(totalPrice);

            bw.write(sb.toString());
        }
    }
}
