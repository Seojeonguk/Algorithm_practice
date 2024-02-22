import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer inputs = new StringTokenizer(br.readLine());

            int originalTicketCnt = Integer.parseInt(inputs.nextToken());
            int attendingPartyPersonCnt = Integer.parseInt(inputs.nextToken());

            if (originalTicketCnt == 0 && attendingPartyPersonCnt == 0) {
                break;
            }

            int[] appearedTickets = new int[originalTicketCnt + 1];

            StringTokenizer receivedTicketInfo = new StringTokenizer(br.readLine());
            while (receivedTicketInfo.hasMoreTokens()) {
                int receivedTicketNum = Integer.parseInt(receivedTicketInfo.nextToken());
                appearedTickets[receivedTicketNum]++;
            }

            int cloneTicketCnt = 0;
            for (int i = 1; i <= originalTicketCnt; i++) {
                if (appearedTickets[i] > 1) {
                    cloneTicketCnt++;
                }
            }

            sb.append(cloneTicketCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
