import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int cardCnt = Integer.parseInt(br.readLine());
        
        int[] skills = new int[cardCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < cardCnt; idx++) {
            skills[idx] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> cards = new ArrayDeque<>();
        for (int card = 1; card <= cardCnt; card++) {
            int skillNum = skills[cardCnt - card];
            if (skillNum == 1) {
                cards.addFirst(card);
            } else if (skillNum == 2) {
                int top = cards.pollFirst();
                cards.addFirst(card);
                cards.addFirst(top);
            } else if (skillNum == 3) {
                cards.addLast(card);
            }
        }

        cards.forEach(card -> sb.append(card).append(" "));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
