import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int birthdayAfterNDays, socksPerDay, minSocksInTwoDays = 3001;
    static int[] socksCosts;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        birthdayAfterNDays = Integer.parseInt(st.nextToken());
        socksPerDay = Integer.parseInt(st.nextToken());

        socksCosts = new int[birthdayAfterNDays];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < birthdayAfterNDays; i++) {
            socksCosts[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                minSocksInTwoDays = Math.min(minSocksInTwoDays, socksCosts[i - 1] + socksCosts[i]);
            }
        }
        sb.append(minSocksInTwoDays * socksPerDay);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
