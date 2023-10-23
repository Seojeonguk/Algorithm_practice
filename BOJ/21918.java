import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int bulbCnt = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());

        boolean[] bulbs = new boolean[bulbCnt + 1];

        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= bulbCnt; idx++) {
            bulbs[idx] = (Integer.parseInt(st.nextToken()) == 0 ? false : true);
        }

        while (commandCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (command == 1) {
                bulbs[l] = (r == 0 ? false : true);
            } else if (command == 2) {
                for (int idx = l; idx <= r; idx++) {
                    bulbs[idx] = !bulbs[idx];
                }
            } else if (command == 3) {
                for (int idx = l; idx <= r; idx++) {
                    bulbs[idx] = false;
                }
            } else if (command == 4) {
                for (int idx = l; idx <= r; idx++) {
                    bulbs[idx] = true;
                }
            }
        }

        for (int idx = 1; idx <= bulbCnt; idx++) {
            sb.append(bulbs[idx] ? 1 : 0).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
