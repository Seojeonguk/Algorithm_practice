import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int inkWordLength = Integer.parseInt(st.nextToken());
        int gridSize = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());

        String ink = br.readLine();

        int squareX = 0, squareY = 0;

        char[][] grid = new char[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            grid[row] = br.readLine().toCharArray();
            for (int col = 0; col < gridSize; col++) {
                if (grid[row][col] == '@') {
                    grid[row][col] = '.';
                    squareX = row;
                    squareY = col;
                }
            }
        }

        char[] commands = br.readLine().toCharArray();

        int inkQuantity = 0;
        int inkColorIdx = 0;

        for (int commandIdx = 0; commandIdx < commandCnt; commandIdx++) {
            if (commands[commandIdx] == 'j') {
                inkQuantity += 1;
            } else if (commands[commandIdx] == 'J') {
                jump(gridSize, grid, inkQuantity, squareX, squareY, ink.charAt(inkColorIdx));
                inkColorIdx = (inkColorIdx + 1) % inkWordLength;
                inkQuantity = 0;
            } else {
                int dir = calNextDirection(commands[commandIdx]);
                int nextX = squareX + DIRS[dir][0];
                int nextY = squareY + DIRS[dir][1];

                if (isOut(nextX, nextY, gridSize) || grid[nextX][nextY] != '.') {
                    continue;
                }
                squareX = nextX;
                squareY = nextY;
            }
        }

        grid[squareX][squareY] = '@';
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                sb.append(grid[row][col]);
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void jump(int gridSize, char[][] grid, int inkQuantity, int x, int y, char color) {
        for (int i = 0; i <= inkQuantity; i++) {
            for (int j = y - i; j <= y + i; j++) {
                int upInkX = x - inkQuantity + i;

                if (!isOut(upInkX, j, gridSize) && grid[upInkX][j] != '.') {
                    grid[upInkX][j] = color;
                }

                int downInkX = x + inkQuantity - i;

                if (!isOut(downInkX, j, gridSize) && grid[downInkX][j] != '.') {
                    grid[downInkX][j] = color;
                }
            }
        }
    }

    public static int calNextDirection(char c) {
        int direction = 0;
        if (c == 'U') direction = 0;
        else if (c == 'D') direction = 1;
        else if (c == 'L') direction = 2;
        else if (c == 'R') direction = 3;
        return direction;
    }

    public static boolean isOut(int x, int y, int size) {
        return x < 0 || y < 0 || x > size - 1 || y > size - 1;
    }
}
