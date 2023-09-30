import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_BULB = 100000;

    public static void main(String[] args) throws Exception {
        int bulbCnt = Integer.parseInt(br.readLine());
        char[] bulbs = br.readLine().toCharArray();
        int firstBulb = getOneBulbColor(bulbCnt, bulbs);

        toggleLight(bulbs, 1);
        int secondMinBulb = getOneBulbColor(bulbCnt, bulbs) + 1;

        toggleLight(bulbs, 1);
        int thirdMinBulb = getOneBulbColor(bulbCnt, bulbs) + 2;

        int minBulb = Math.min(firstBulb, Math.min(secondMinBulb, thirdMinBulb));

        sb.append(minBulb == MAX_BULB * 10 ? -1 : minBulb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getOneBulbColor(int bulbCnt, char[] bulbs) {
        char[] bulbsCpy = Arrays.copyOf(bulbs, bulbCnt);
        int toggleCnt = 0;

        for (int idx = 2; idx < bulbCnt - 1; idx++) {
            while (bulbsCpy[0] != bulbsCpy[idx - 1]) {
                toggleLight(bulbsCpy, idx);
                toggleCnt++;
            }
        }

        for (int idx = 1; idx < bulbCnt; idx++) {
            if (bulbsCpy[0] != bulbsCpy[idx]) {
                toggleCnt = MAX_BULB * 10;
                break;
            }
        }

        return toggleCnt;
    }

    public static void toggleLight(char[] bulbs, int idx) {
        bulbs[idx - 1] = getToggleColor(bulbs[idx - 1]);
        bulbs[idx] = getToggleColor(bulbs[idx]);
        bulbs[idx + 1] = getToggleColor(bulbs[idx + 1]);
    }

    public static char getToggleColor(char curLight) {
        char nextLight = 'R';
        if (curLight == 'R') {
            nextLight = 'G';
        } else if (curLight == 'G') {
            nextLight = 'B';
        } else if (curLight == 'B') {
            nextLight = 'R';
        }
        return nextLight;
    }
}
