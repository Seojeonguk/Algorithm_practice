import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws Exception {
        int mapSize = Integer.parseInt(br.readLine());
        int[][] mines = new int[mapSize][mapSize];
        boolean[][] onMine = new boolean[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < mapSize; j++) {
                if (line[j] != '.') {
                    onMine[i][j] = true;
                    calMine(mines, i, j, line[j] - '0');
                }
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (!onMine[i][j]) {
                    sb.append(mines[i][j] >= 10 ? "M" : mines[i][j]);
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void calMine(int[][] mines, int x, int y, int mineCnt) {
        for (int i = 0; i < 8; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (isOut(mines.length, nextX, nextY)) {
                continue;
            }
            mines[nextX][nextY] += mineCnt;
        }
    }

    public static boolean isOut(int mapSize, int x, int y) {
        return x < 0 || y < 0 || x > mapSize - 1 || y > mapSize - 1;
    }
}
