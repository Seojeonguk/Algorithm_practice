import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int LINE = 10;
    static final int LINE_PER_SEAT = 20;

    public static void main(String[] args) throws Exception {
        char[][] seats = new char[LINE][LINE_PER_SEAT];
        for (int i = 0; i < LINE; i++) {
            Arrays.fill(seats[i], '.');
        }
        int reservationCnt = Integer.parseInt(br.readLine());

        while (reservationCnt-- > 0) {
            String reservationInfo = br.readLine();
            int line = reservationInfo.charAt(0) - 'A';
            int lineNum = Integer.parseInt(reservationInfo.substring(1)) - 1;

            seats[line][lineNum] = 'o';
        }

        for (int i = 0; i < LINE; i++) {
            for (int j = 0; j < LINE_PER_SEAT; j++) {
                sb.append(seats[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
