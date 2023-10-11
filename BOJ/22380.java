import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int participantCnt = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (participantCnt == 0) {
                break;
            }

            int partyCostPerPerson = cost / participantCnt;

            int partyCost = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < participantCnt; i++) {
                int money = Integer.parseInt(st.nextToken());
                partyCost += Math.min(partyCostPerPerson, money);
            }
            sb.append(partyCost).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
