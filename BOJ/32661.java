import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int availableFlightCnt = Integer.parseInt(br.readLine());
            int[] flightPrices = new int[availableFlightCnt];

            for (int idx = 0; idx < availableFlightCnt; idx++) {
                flightPrices[idx] = Integer.parseInt(br.readLine());
            }

            int reimbursement = Arrays.stream(flightPrices).max().getAsInt() / 2;
            int pay = Arrays.stream(flightPrices).min().getAsInt();

            sb.append(pay <= reimbursement ? 0 : pay - reimbursement);

            bw.write(sb.toString());
        }
    }
}
