import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int questionerCnt = Integer.parseInt(st.nextToken());
        int examinerCnt = Integer.parseInt(st.nextToken());

        int[] gainMoneys = new int[questionerCnt + examinerCnt];

        st = new StringTokenizer(br.readLine());
        for (int questioner = 0; questioner < questionerCnt; questioner++) {
            gainMoneys[questioner] = Integer.parseInt(st.nextToken());
        }

        for (int questioner = 0; questioner < questionerCnt; questioner++) {
            st = new StringTokenizer(br.readLine());
            for (int num = 0; num < questionerCnt + examinerCnt; num++) {
                int gainMoney = Integer.parseInt(st.nextToken());
                gainMoneys[questioner] -= gainMoney;
                gainMoneys[num] += gainMoney;
            }
        }

        for (int num = 0; num < questionerCnt + examinerCnt; num++) {
            sb.append(gainMoneys[num]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
