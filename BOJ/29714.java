import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int currentMarbleCnt = Integer.parseInt(br.readLine());
        Map<Integer, Integer> marbles = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < currentMarbleCnt; i++) {
            int marbleColor = Integer.parseInt(st.nextToken());
            int marbleCnt = (marbles.containsKey(marbleColor) ? marbles.get(marbleColor) : 0) + 1;
            marbles.put(marbleColor, marbleCnt);
        }
        int query = Integer.parseInt(br.readLine());
        Map<Integer, Integer> eatingMarbles = new HashMap<>();
        while (query-- > 0) {
            eatingMarbles.clear();
            boolean canEat = true;

            st = new StringTokenizer(br.readLine());
            int eatingCnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < eatingCnt; i++) {
                int marbleColor = Integer.parseInt(st.nextToken());
                int marbleCnt = (eatingMarbles.containsKey(marbleColor) ? eatingMarbles.get(marbleColor) : 0) + 1;
                eatingMarbles.put(marbleColor, marbleCnt);
                if (!marbles.containsKey(marbleColor) || marbleCnt > marbles.get(marbleColor)) {
                    canEat = false;
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            if (!canEat) {
                continue;
            }

            Iterator<Integer> it = eatingMarbles.keySet().iterator();
            while (it.hasNext()) {
                int marbleColor = it.next();
                int eatingMarbleCnt = eatingMarbles.get(marbleColor);
                int marbleCnt = marbles.get(marbleColor);

                if (marbleCnt == eatingMarbleCnt) {
                    marbles.remove(marbleColor);
                } else {
                    marbles.put(marbleColor, marbleCnt - eatingMarbleCnt);
                }
            }
            currentMarbleCnt -= eatingCnt;

            int addCnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < addCnt; i++) {
                int marbleColor = Integer.parseInt(st.nextToken());
                int marbleCnt = (marbles.containsKey(marbleColor) ? marbles.get(marbleColor) : 0) + 1;

                marbles.put(marbleColor, marbleCnt);
            }
            currentMarbleCnt += addCnt;
        }
        sb.append(currentMarbleCnt).append("\n");
        if (!marbles.isEmpty()) {
            Iterator<Integer> it = marbles.keySet().iterator();
            while (it.hasNext()) {
                int marbleColor = it.next();
                int marbleCnt = marbles.get(marbleColor);
                for (int i = 0; i < marbleCnt; i++) {
                    sb.append(marbleColor).append(" ");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
