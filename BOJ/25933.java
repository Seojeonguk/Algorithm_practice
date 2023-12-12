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

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int[] usamedals = new int[3];
            int[] russiaMedals = new int[3];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                usamedals[i] = Integer.parseInt(st.nextToken());
                sb.append(usamedals[i]).append(" ");
            }

            for (int i = 0; i < 3; i++) {
                russiaMedals[i] = Integer.parseInt(st.nextToken());
                sb.append(russiaMedals[i]).append(" ");
            }

            int totalUSAMedal = Arrays.stream(usamedals).sum();
            int totalRussiaMedal = Arrays.stream(russiaMedals).sum();

            boolean isUsaWin = false;
            if (usamedals[0] > russiaMedals[0] || (usamedals[0] == russiaMedals[0] && usamedals[1] > russiaMedals[1]) || (usamedals[0] == russiaMedals[0] && usamedals[1] == russiaMedals[1] && usamedals[2] > russiaMedals[2])) {
                isUsaWin = true;
            }

            sb.append("\n");
            if (totalUSAMedal > totalRussiaMedal && isUsaWin) {
                sb.append("both");
            } else if (totalUSAMedal > totalRussiaMedal) {
                sb.append("count");
            } else if (isUsaWin) {
                sb.append("color");
            } else {
                sb.append("none");
            }
            sb.append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
