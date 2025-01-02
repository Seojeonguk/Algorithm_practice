import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int parkingSize = Integer.parseInt(br.readLine());
            char[] yesterdayParkingInfos = br.readLine().toCharArray();
            char[] todayParkingInfos = br.readLine().toCharArray();

            int occupiedBothCnt = 0;

            for (int idx = 0; idx < parkingSize; idx++) {
                if (yesterdayParkingInfos[idx] == 'C' && todayParkingInfos[idx] == 'C') {
                    occupiedBothCnt++;
                }
            }

            sb.append(occupiedBothCnt);

            bw.write(sb.toString());
        }
    }
}
