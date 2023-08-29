import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int cardCnt = Integer.parseInt(st.nextToken());
        int combineCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> cards = new PriorityQueue<>();
        for (int i = 0; i < cardCnt; i++) {
            long card = Long.parseLong(st.nextToken());
            cards.add(card);
        }

        for (int combine = 0; combine < combineCnt; combine++) {
            long x = cards.poll();
            long y = cards.poll();
            cards.add(x + y);
            cards.add(x + y);
        }

        long sum = 0;
        while (!cards.isEmpty()) {
            sum += cards.poll();
        }
        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
