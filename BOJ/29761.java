import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        int[][] heights = new int[n][n];
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                heights[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isWater = new boolean[n][n];
        PriorityQueue<Water> waters = new PriorityQueue<>((o1, o2) -> {
            if (o1.height == o2.height) return Integer.compare(o2.quantity, o1.quantity);
            return Integer.compare(o2.height, o1.height);
        });
        isWater[startX][startY] = true;
        waters.add(new Water(startX, startY, heights[startX][startY], X));
        while (!waters.isEmpty()) {
            Water water = waters.poll();

            for (int d = 0; d < DIRS.length; d++) {
                int nx = water.x + DIRS[d][0];
                int ny = water.y + DIRS[d][1];

                if (isOut(nx, ny, n) || isWater[nx][ny] || heights[water.x][water.y] < heights[nx][ny] || water.quantity == 1) {
                    continue;
                }

                int nWater = (heights[water.x][water.y] == heights[nx][ny] ? water.quantity - 1 : X);
                isWater[nx][ny] = true;
                waters.add(new Water(nx, ny, heights[nx][ny], nWater));
            }
        }

        int waterCnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isWater[row][col]) {
                    waterCnt++;
                }
            }
        }
        sb.append(waterCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int x, int y, int n) {
        return x < 0 || y < 0 || x > n - 1 || y > n - 1;
    }

    static class Water {
        int x;
        int y;
        int height;
        int quantity;

        Water(int x, int y, int height, int quantity) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.quantity = quantity;
        }
    }
}
