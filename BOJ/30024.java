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
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        int[][] cornfield = new int[rowSize][colSize];
        PriorityQueue<Corn> corns = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.quantity, o1.quantity));
        boolean[][] isVisit = new boolean[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                cornfield[row][col] = Integer.parseInt(st.nextToken());
                if (row == 0 || row == rowSize - 1 || col == 0 || col == colSize - 1) {
                    isVisit[row][col] = true;
                    corns.add(new Corn(row, col, cornfield[row][col]));
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            Corn harvestedCorn = corns.poll();
            sb.append(harvestedCorn.x + 1).append(" ").append(harvestedCorn.y + 1).append("\n");

            for (int dir = 0; dir < 4; dir++) {
                int nextX = harvestedCorn.x + DIRS[dir][0];
                int nextY = harvestedCorn.y + DIRS[dir][1];

                if (isOut(nextX, nextY, rowSize, colSize) || isVisit[nextX][nextY]) {
                    continue;
                }
                isVisit[nextX][nextY] = true;
                corns.add(new Corn(nextX, nextY, cornfield[nextX][nextY]));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int x, int y, int row, int col) {
        return x < 0 || y < 0 || x > row - 1 || y > col - 1;
    }

    static class Corn {
        int x;
        int y;
        int quantity;

        Corn(int x, int y, int quantity) {
            this.x = x;
            this.y = y;
            this.quantity = quantity;
        }
    }
}
