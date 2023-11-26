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

    static final int PLAYER_CNT = 11;

    public static void main(String[] args) throws Exception {
        String str;
        while ((str = br.readLine()) != null && !"".equals(str)) {
            int tc = Integer.parseInt(str);

            while (tc-- > 0) {
                int[][] stats = new int[PLAYER_CNT][PLAYER_CNT];
                boolean[] isSelected = new boolean[PLAYER_CNT];
                for (int player = 0; player < PLAYER_CNT; player++) {
                    st = new StringTokenizer(br.readLine());
                    for (int position = 0; position < PLAYER_CNT; position++) {
                        stats[player][position] = Integer.parseInt(st.nextToken());
                    }
                }

                int maxSumStat = getMaxSumStat(stats, isSelected, 0, 0);
                sb.append(maxSumStat).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMaxSumStat(int[][] stats, boolean[] isSelected, int player, int sumStat) {
        if (player == PLAYER_CNT) {
            return sumStat;
        }

        int maxSumStat = 0;
        for (int position = 0; position < PLAYER_CNT; position++) {
            if (stats[player][position] > 0 && !isSelected[position]) {
                isSelected[position] = true;
                maxSumStat = Math.max(maxSumStat, getMaxSumStat(stats, isSelected, player + 1, sumStat + stats[player][position]));
                isSelected[position] = false;
            }
        }

        return maxSumStat;
    }
}
