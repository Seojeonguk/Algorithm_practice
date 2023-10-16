import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int USE_NUM = 10;
    final static int USE_LETTER = 26;

    public static void main(String[] args) throws Exception {
        String carNumberFormat = br.readLine();

        int canCarNum = (carNumberFormat.charAt(0) == 'c' ? USE_LETTER : USE_NUM);
        for (int idx = 1; idx < carNumberFormat.length(); idx++) {
            int useWay = (carNumberFormat.charAt(idx) == 'c' ? USE_LETTER : USE_NUM);
            if (carNumberFormat.charAt(idx) == carNumberFormat.charAt(idx - 1)) {
                useWay--;
            }
            canCarNum *= useWay;
        }
        sb.append(canCarNum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
