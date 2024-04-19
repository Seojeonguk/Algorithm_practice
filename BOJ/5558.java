import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int factoryCnt = Integer.parseInt(st.nextToken());

            int startX = -1, startY = -1;
            char[][] villages = new char[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                villages[row] = br.readLine().toCharArray();
                for (int col = 0; col < colSize; col++) {
                    if (villages[row][col] == 'S') {
                        startX = row;
                        startY = col;
                        villages[row][col] = '.';
                    }
                }
            }

            sb.append(fastestEatingAllCheese(rowSize, colSize, factoryCnt, villages, startX, startY));

            bw.write(sb.toString());
        }
    }

    public static int fastestEatingAllCheese(int rowSize, int colSize, int factoryCnt, char[][] villages, int startX, int startY) {
        boolean[][][] visited = new boolean[rowSize][colSize][factoryCnt + 2];

        Queue<Mouse> q = new LinkedList<>();
        q.add(new Mouse(startX, startY, 1, 0));
        visited[startX][startY][1] = true;

        int fastestTime = -1;
        while (!q.isEmpty()) {
            Mouse cur = q.poll();

            if (cur.HP == factoryCnt + 1) {
                fastestTime = cur.time;
                break;
            }

            for (int dir = 0; dir < DIRS.length; dir++) {
                int nx = cur.x + DIRS[dir][0];
                int ny = cur.y + DIRS[dir][1];
                int nextHP = cur.HP;
                int nextTime = cur.time + 1;

                if (isOut(rowSize, colSize, nx, ny) || villages[nx][ny] == 'X') {
                    continue;
                }

                if (villages[nx][ny] != '.' && villages[nx][ny] - '0' == nextHP) {
                    nextHP++;
                }

                if (visited[nx][ny][nextHP]) {
                    continue;
                }

                q.add(new Mouse(nx, ny, nextHP, nextTime));
                visited[nx][ny][nextHP] = true;
            }
        }

        return fastestTime;
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }

    static class Mouse {
        int x, y, HP, time;

        Mouse(int x, int y, int HP, int time) {
            this.x = x;
            this.y = y;
            this.HP = HP;
            this.time = time;
        }
    }
}
