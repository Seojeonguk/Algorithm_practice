import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final char[] DIRS = {'U', 'R', 'D', 'L'};
    static final int[][] ADD_DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer starSystemSizeInfo = new StringTokenizer(br.readLine());
            int systemRowSize = Integer.parseInt(starSystemSizeInfo.nextToken());
            int systemColSize = Integer.parseInt(starSystemSizeInfo.nextToken());

            char[][] starSystems = new char[systemRowSize][systemColSize];
            for (int row = 0; row < systemRowSize; row++) {
                starSystems[row] = br.readLine().toCharArray();
            }

            StringTokenizer probeInfo = new StringTokenizer(br.readLine());
            int probeX = Integer.parseInt(probeInfo.nextToken()) - 1;
            int probeY = Integer.parseInt(probeInfo.nextToken()) - 1;

            int longestTime = 0, longestTimeDir = -1;
            for (int dir = 0; dir < 4; dir++) {
                int time = calTime(systemRowSize, systemColSize, starSystems, dir, probeX, probeY);
                if (longestTime < time) {
                    longestTime = time;
                    longestTimeDir = dir;
                }
            }

            sb.append(DIRS[longestTimeDir]).append("\n");
            sb.append(longestTime == Integer.MAX_VALUE ? "Voyager" : longestTime);

            bw.write(sb.toString());
        }
    }

    public static int calTime(int xSize, int ySize, char[][] systems, int startDir, int probeX, int probeY) {
        boolean[][][] isVisit = new boolean[xSize][ySize][4];
        int time = 0;

        int x = probeX, y = probeY, dir = startDir;

        while (true) {
            time++;
            int nx = x + ADD_DIRS[dir][0];
            int ny = y + ADD_DIRS[dir][1];

            if (isOut(xSize, ySize, nx, ny) || systems[nx][ny] == 'C') {
                break;
            }

            if (isVisit[nx][ny][dir]) {
                return Integer.MAX_VALUE;
            }

            if (systems[nx][ny] == '/' || systems[nx][ny] == '\\') {
                isVisit[nx][ny][dir] = true;
                dir = changeDir(systems[nx][ny], dir);
            }

            x = nx;
            y = ny;
        }

        return time;
    }

    public static int changeDir(char planet, int dir) {
        if (planet == '/') {
            return dir / 2 * 2 + 1 - dir % 2;
        } else {
            return 3 - dir;
        }
    }

    public static boolean isOut(int xSize, int ySize, int x, int y) {
        return (x < 0 || y < 0 || x > xSize - 1 || y > ySize - 1);
    }
}
