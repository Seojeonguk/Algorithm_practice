import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int seatCnt = Integer.parseInt(br.readLine());
        char[] morningWaters = br.readLine().toCharArray();
        char[] eveningWaters = br.readLine().toCharArray();

        boolean isAllSame = true;
        int morningWaterCnt = 0;
        int eveningWaterCnt = 0;

        for (int idx = 0; idx < seatCnt; idx++) {
            if (morningWaters[idx] == 'w') {
                morningWaterCnt += 1;
            }
            if (eveningWaters[idx] == 'w') {
                eveningWaterCnt += 1;
            }

            if (morningWaters[idx] != eveningWaters[idx]) {
                isAllSame = false;
            }
        }

        if (isAllSame) {
            sb.append("Good");
        } else if (morningWaterCnt < eveningWaterCnt) {
            sb.append("Manners maketh man");
        } else if (eveningWaterCnt < morningWaterCnt) {
            sb.append("Oryang");
        } else {
            sb.append("Its fine");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
