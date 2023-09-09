import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        char[][] penguinVillages = new char[rowSize][colSize];
        Penguin penguin = new Penguin(-1, -1, 0, 0);
        for (int row = 0; row < rowSize; row++) {
            penguinVillages[row] = br.readLine().toCharArray();
            for (int col = 0; col < colSize; col++) {
                if (penguinVillages[row][col] == 'S') {
                    penguin.x = row;
                    penguin.y = col;
                }
            }
        }

        int destinationTime = getDestinationTime(penguin, rowSize, colSize, penguinVillages);
        sb.append(destinationTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getDestinationTime(Penguin startPenguin, int rowSize, int colSize, char[][] penguinVillages) {
        Queue<Penguin> possiblePenguinPlace = new LinkedList<>();
        possiblePenguinPlace.add(startPenguin);

        boolean[][][] isVisit = new boolean[rowSize][colSize][2];
        isVisit[startPenguin.x][startPenguin.y][0] = true;

        while (!possiblePenguinPlace.isEmpty()) {
            Penguin penguin = possiblePenguinPlace.poll();

            if (penguinVillages[penguin.x][penguin.y] == 'H' && penguin.isHunting == 1) {
                return penguin.cnt;
            }

            for (int d = 0; d < DIRS.length; d++) {
                int nx = penguin.x + DIRS[d][0];
                int ny = penguin.y + DIRS[d][1];
                int nCnt = penguin.cnt + 1;

                if (isOut(nx, ny, rowSize, colSize) || penguinVillages[nx][ny] == 'D') {
                    continue;
                }
                int isHunting = penguin.isHunting;
                if (penguinVillages[nx][ny] == 'F') {
                    isHunting = 1;
                }
                if (isVisit[nx][ny][isHunting]) {
                    continue;
                }
                isVisit[nx][ny][isHunting] = true;
                possiblePenguinPlace.add(new Penguin(nx, ny, nCnt, isHunting));
            }
        }

        return -1;
    }

    public static boolean isOut(int x, int y, int rSize, int cSize) {
        return x < 0 || y < 0 || x > rSize - 1 || y > cSize - 1;
    }

    static class Penguin {
        int x;
        int y;
        int cnt;
        int isHunting;

        Penguin(int x, int y, int cnt, int isHunting) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isHunting = isHunting;
        }
    }
}
