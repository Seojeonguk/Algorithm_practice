import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static char MINE = '*';

    final static int[][] DIRS = {
            {-1, -1, -1}, {-1, -1, 0}, {-1, -1, 1},
            {-1, 0, -1}, {-1, 0, 0}, {-1, 0, 1},
            {-1, 1, -1}, {-1, 1, 0}, {-1, 1, 1},
            {0, -1, -1}, {0, -1, 0}, {0, -1, 1},
            {0, 0, -1}, {0, 0, 1},
            {0, 1, -1}, {0, 1, 0}, {0, 1, 1},
            {1, -1, -1}, {1, -1, 0}, {1, -1, 1},
            {1, 0, -1}, {1, 0, 0}, {1, 0, 1},
            {1, 1, -1}, {1, 1, 0}, {1, 1, 1}
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int heightSize = Integer.parseInt(st.nextToken());
        char[][][] cubes = new char[heightSize][rowSize][colSize];

        for (int height = 0; height < heightSize; height++) {
            for (int row = 0; row < rowSize; row++) {
                cubes[height][row] = br.readLine().toCharArray();
            }
        }

        for (int height = 0; height < heightSize; height++) {
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    if (cubes[height][row][col] != MINE) {
                        int nearMineCnt = 0;
                        for (int dir = 0; dir < DIRS.length; dir++) {
                            int nextRow = row + DIRS[dir][0];
                            int nextCol = col + DIRS[dir][1];
                            int nextHeight = height + DIRS[dir][2];

                            if (nextRow < 0 || nextCol < 0 || nextHeight < 0 || nextRow > rowSize - 1 || nextCol > colSize - 1 || nextHeight > heightSize - 1) {
                                continue;
                            }
                            if (cubes[nextHeight][nextRow][nextCol] == MINE) {
                                nearMineCnt++;
                            }
                        }
                        sb.append(nearMineCnt % 10);
                    } else {
                        sb.append(MINE);
                    }
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
