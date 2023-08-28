import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int limitMoney = Integer.parseInt(st.nextToken());
        int auctionCnt = Integer.parseInt(st.nextToken());
        String[] firstName = new String[limitMoney + 1];
        int[] cnt = new int[limitMoney + 1];

        for (int i = 0; i < auctionCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());
            if (cnt[money] == 0) {
                firstName[money] = name;
            }
            cnt[money]++;
        }

        cnt[0] = 100001;
        int minIdx = 0;
        for (int idx = 1; idx <= limitMoney; idx++) {
            if (cnt[idx] > 0 && cnt[minIdx] > cnt[idx]) {
                minIdx = idx;
            }
        }

        sb.append(String.format("%s %d", firstName[minIdx], minIdx));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
