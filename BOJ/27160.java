import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int cardCnt = Integer.parseInt(br.readLine());
        Map<String, Integer> cards = new HashMap<>();
        for (int card = 0; card < cardCnt; card++) {
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            if (cards.containsKey(fruit)) {
                cnt += cards.get(fruit);
            }
            cards.put(fruit, cnt);
        }

        boolean canTouchBell = false;
        Iterator<String> fruits = cards.keySet().iterator();
        while (fruits.hasNext()) {
            String fruit = fruits.next();
            int fruitCnt = cards.get(fruit);
            if (fruitCnt == 5) {
                canTouchBell = true;
                break;
            }
        }

        sb.append(canTouchBell ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
