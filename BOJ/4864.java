import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MAX_DAY = 10000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] gainGoldCoins = new int[MAX_DAY + 1];
        int coin = 0, coinCnt = 0, increaseCoin = 1;
        for (int day = 1; day <= MAX_DAY; day++) {
            if (coinCnt == 0) {
                coinCnt = increaseCoin;
                coin++;
                increaseCoin++;
            }

            gainGoldCoins[day] = gainGoldCoins[day - 1] + coin;
            coinCnt--;
        }

        for (int tc = 0; ; tc++) {
            int day = Integer.parseInt(br.readLine());
            if (day == 0) {
                break;
            }
            sb.append(day).append(" ").append(gainGoldCoins[day]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
