import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String FAIL = "Fail";
    final static int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int timeLimit = Integer.parseInt(st.nextToken());

        int[][] castle = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                castle[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int rescueTime = getRescueTime(rowSize, colSize, castle, timeLimit);
        sb.append(rescueTime == -1 ? FAIL : rescueTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getRescueTime(int rowSize, int colSize, int[][] castle, int timeLimit) {
        boolean[][][] isVisit = new boolean[rowSize][colSize][2];
        Queue<Warrior> warriors = new LinkedList<>();
        isVisit[0][0][0] = true;
        warriors.add(new Warrior(0, 0, 0, false));
        while (!warriors.isEmpty()) {
            Warrior warrior = warriors.poll();

            if (warrior.x == rowSize - 1 && warrior.y == colSize - 1) {
                return warrior.cnt;
            }
            if (warrior.cnt == timeLimit) {
                continue;
            }

            for (int d = 0; d < DIRS.length; d++) {
                int nx = warrior.x + DIRS[d][0];
                int ny = warrior.y + DIRS[d][1];

                if (isOut(nx, ny, rowSize, colSize) || isVisit[nx][ny][warrior.isGetSword ? 1 : 0]) {
                    continue;
                }
                if (castle[nx][ny] == 1 && !warrior.isGetSword) {
                    continue;
                }
                boolean nIsGetSword = (warrior.isGetSword | castle[nx][ny] == 2);

                isVisit[nx][ny][nIsGetSword ? 1 : 0] = true;
                warriors.add(new Warrior(nx, ny, warrior.cnt + 1, warrior.isGetSword | castle[nx][ny] == 2));
            }
        }
        return -1;
    }

    public static boolean isOut(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x > n - 1 || y > m - 1;
    }

    static class Warrior {
        int x;
        int y;
        int cnt;
        boolean isGetSword;

        Warrior(int x, int y, int cnt, boolean isGetSword) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isGetSword = isGetSword;
        }
    }
}
