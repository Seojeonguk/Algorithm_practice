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

    static final int STICK_CNT = 3;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        Stick[] sticks = new Stick[STICK_CNT];
        for (int i = 0; i < STICK_CNT; i++) {
            int stickLength = Integer.parseInt(st.nextToken());
            sticks[i] = new Stick(stickLength);
        }
        for (int i = 0; i < STICK_CNT; i++) {
            int stickCnt = Integer.parseInt(st.nextToken());
            sticks[i].setCnt(stickCnt);
        }

        int minLength = Integer.parseInt(st.nextToken());

        Arrays.sort(sticks, Comparator.comparing(Stick::getLength).reversed());

        sb.append(getStickCnt(sticks, minLength));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getStickCnt(Stick[] sticks, int minLength) {
        int sumStickLengths = 0;
        int stickCnt = 0;
        boolean canSatisfied = false;
        Loop1:
        for (int i = 0; i < STICK_CNT; i++) {
            for (int j = 0; j < sticks[i].cnt; j++) {
                sumStickLengths += sticks[i].length;
                stickCnt++;
                if (sumStickLengths >= minLength) {
                    canSatisfied = true;
                    break Loop1;
                }
            }
        }

        return canSatisfied ? stickCnt : 0;
    }

    static class Stick {
        int length;
        int cnt;

        Stick(int length) {
            this.length = length;
            this.cnt = 0;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public int getLength() {
            return length;
        }
    }
}
