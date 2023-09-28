import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int rentalOfficeCnt = Integer.parseInt(br.readLine());
        int[] beforeRentalOffices = new int[rentalOfficeCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < rentalOfficeCnt; idx++) {
            beforeRentalOffices[idx] = Integer.parseInt(st.nextToken());
        }

        int[] afterRentalOffices = new int[rentalOfficeCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < rentalOfficeCnt; idx++) {
            afterRentalOffices[idx] = Integer.parseInt(st.nextToken());
        }

        int minMoveBiCycle = 0;
        for (int idx = 0; idx < rentalOfficeCnt; idx++) {
            if (beforeRentalOffices[idx] < afterRentalOffices[idx]) {
                minMoveBiCycle += Math.abs(beforeRentalOffices[idx] - afterRentalOffices[idx]);
            }
        }
        sb.append(minMoveBiCycle);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
