import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String[] COLORS = {"RED", "GREEN", "BLUE"};
    final static int[][] ADDED_COLOR = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    final static int COLOR_CNT = 3;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            int maxMoney = 0;
            String addedColor = "";
            for (int idx = 0; idx < ADDED_COLOR.length; idx++) {
                int addedMoney = getMoney(a, c, red + ADDED_COLOR[idx][0], green + ADDED_COLOR[idx][1], blue + ADDED_COLOR[idx][2]);
                if (addedMoney > maxMoney) {
                    maxMoney = addedMoney;
                    addedColor = COLORS[idx];
                }
            }
            sb.append(addedColor).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMoney(int a, int c, int r, int g, int b) {
        int money = 0;
        money = a * (r * r + g * g + b * b) + c * Math.min(r, Math.min(g, b));
        return money;
    }
}
