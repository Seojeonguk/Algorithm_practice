import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int LOTTO_MAX_NUM = 49;
    static final int NUMBER_PER_TICKET = 6;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int purchasedTickets = Integer.parseInt(br.readLine());
            if (purchasedTickets == 0) {
                break;
            }

            int[][] tickets = new int[purchasedTickets][NUMBER_PER_TICKET];
            for (int i = 0; i < purchasedTickets; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < NUMBER_PER_TICKET; j++) {
                    tickets[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            sb.append(checkAllLottoNumbersAppeared(tickets) ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkAllLottoNumbersAppeared(int[][] tickets) {
        boolean[] appearedLottoNum = new boolean[LOTTO_MAX_NUM + 1];
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                appearedLottoNum[tickets[i][j]] = true;
            }
        }

        boolean allNumbersAppeared = true;
        for (int i = 1; i <= LOTTO_MAX_NUM; i++) {
            allNumbersAppeared &= appearedLottoNum[i];
        }

        return allNumbersAppeared;
    }
}
