import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] X = {-1, 1, 0, 0};
    static int[] Y = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        int woodBlockSize = Integer.parseInt(br.readLine());
        char[][] woodBlocks = new char[woodBlockSize][woodBlockSize];

        int x = 0, y = 0;

        String robotArmMovement = br.readLine();
        for (int idx = 0; idx < robotArmMovement.length(); idx++) {
            char dir = robotArmMovement.charAt(idx);
            int dirIdx = getDirIdx(dir);

            int nextX = x + X[dirIdx];
            int nextY = y + Y[dirIdx];
            if (isOut(nextX, nextY, woodBlockSize)) {
                continue;
            }

            if (dirIdx <= 1) {
                woodBlocks[x][y] |= 1;
                woodBlocks[nextX][nextY] |= 1;
            } else {
                woodBlocks[x][y] |= 2;
                woodBlocks[nextX][nextY] |= 2;
            }
            x = nextX;
            y = nextY;
        }

        for (int i = 0; i < woodBlockSize; i++) {
            for (int j = 0; j < woodBlockSize; j++) {
                if (woodBlocks[i][j] == 3) {
                    sb.append("+");
                } else if (woodBlocks[i][j] == 2) {
                    sb.append("-");
                } else if (woodBlocks[i][j] == 1) {
                    sb.append("|");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int getDirIdx(char dir) {
        int dirIdx = 0;
        if (dir == 'U') {
            dirIdx = 0;
        } else if (dir == 'D') {
            dirIdx = 1;
        } else if (dir == 'L') {
            dirIdx = 2;
        } else if (dir == 'R') {
            dirIdx = 3;
        }
        return dirIdx;
    }

    static boolean isOut(int x, int y, int n) {
        return x < 0 || y < 0 || x > n - 1 || y > n - 1;
    }
}
