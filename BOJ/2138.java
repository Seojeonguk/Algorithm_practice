import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static Character ON = '1';
    final static Character OFF = '0';

    final static int CANNOT_MAKE_TARGET = 100002;

    public static void main(String[] args) throws Exception {
        int bulbCnt = Integer.parseInt(br.readLine());
        char[] current = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        int switchClickCnt = getClickCnt(current, target);

        current[0] = toggle(current[0]);
        current[1] = toggle(current[1]);

        int switchClickCnt2 = getClickCnt(current, target) + 1;

        int minSwitchClickCnt = Math.min(switchClickCnt, switchClickCnt2);
        sb.append(minSwitchClickCnt == CANNOT_MAKE_TARGET ? -1 : minSwitchClickCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getClickCnt(char[] c, char[] t) {
        char[] copyC = Arrays.copyOf(c, c.length);
        int ret = CANNOT_MAKE_TARGET;
        int toggleCnt = 0;
        for (int idx = 1; idx < c.length; idx++) {
            if (copyC[idx - 1] != t[idx - 1]) {
                toggleCnt++;
                copyC[idx - 1] = toggle(copyC[idx - 1]);
                copyC[idx] = toggle(copyC[idx]);
                if (idx != c.length - 1) {
                    copyC[idx + 1] = toggle(copyC[idx + 1]);
                }
            }
        }
        if (copyC[c.length - 1] == t[t.length - 1]) {
            ret = toggleCnt;
        }
        return ret;
    }

    public static Character toggle(char c) {
        return c == ON ? OFF : ON;
    }
}
