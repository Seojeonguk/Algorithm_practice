import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int sx = -1;
    static int sy = -1;
    static int additionalHP = -1;
    static int[][] villages;
    static int maxMilk = 0;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int villageSize = Integer.parseInt(st.nextToken());
            int initialHP = Integer.parseInt(st.nextToken());
            additionalHP = Integer.parseInt(st.nextToken());

            villages = new int[villageSize][villageSize];
            ArrayList<int[]> milks = new ArrayList<>();
            for (int i = 0; i < villageSize; i++) {
                StringTokenizer rowVillage = new StringTokenizer(br.readLine());
                for (int j = 0; j < villageSize; j++) {
                    villages[i][j] = Integer.parseInt(rowVillage.nextToken());
                    if (villages[i][j] == 1) {
                        sx = i;
                        sy = j;
                    } else if (villages[i][j] == 2) {
                        milks.add(new int[]{i, j});
                    }
                }
            }

            boolean[] visited = new boolean[milks.size()];
            calMaxMilk(milks, visited, initialHP, sx, sy, 0);
            sb.append(maxMilk);

            bw.write(sb.toString());
        }
    }

    public static void calMaxMilk(ArrayList<int[]> milks, boolean[] visited, int HP, int x, int y, int milk) {
        if (calDistance(sx, sy, x, y) <= HP) {
            maxMilk = Math.max(maxMilk, milk);
        }

        int length = milks.size();
        for (int idx = 0; idx < length; idx++) {
            int[] next = milks.get(idx);
            if (visited[idx]) {
                continue;
            }

            int nextDistance = calDistance(x, y, next[0], next[1]);
            if (nextDistance > HP) {
                continue;
            }

            visited[idx] = true;
            calMaxMilk(milks, visited, HP - nextDistance + additionalHP, next[0], next[1], milk + 1);
            visited[idx] = false;
        }
    }

    public static int calDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
