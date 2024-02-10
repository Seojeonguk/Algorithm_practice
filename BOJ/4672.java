import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int mapSize = Integer.parseInt(br.readLine());
            if (mapSize == 0) {
                break;
            }
            char[][] maps = new char[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                maps[i] = br.readLine().toCharArray();
            }

            boolean[][] visited = new boolean[mapSize][mapSize];
            int maxRook = calMaxRook(mapSize, maps, visited, -1, 0);
            sb.append(maxRook).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMaxRook(int mapSize, char[][] maps, boolean[][] visited, int place, int rook) {
        int maxRook = rook;

        for (int i = place + 1; i < mapSize * mapSize; i++) {
            int x = i / mapSize;
            int y = i % mapSize;

            if (maps[x][y] == 'X' || !canRookPlace(maps, x, y, visited)) {
                continue;
            }

            visited[x][y] = true;
            maxRook = Math.max(maxRook, calMaxRook(mapSize, maps, visited, i, rook + 1));
            visited[x][y] = false;
        }

        return maxRook;
    }

    public static boolean canRookPlace(char[][] maps, int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nx = x + DIRS[i][0], ny = y + DIRS[i][1];

            while (!isOut(maps.length, nx, ny) && maps[nx][ny] != 'X') {
                if (visited[nx][ny]) {
                    return false;
                }
                nx += DIRS[i][0];
                ny += DIRS[i][1];
            }
        }
        return true;
    }

    public static boolean isOut(int mapSize, int x, int y) {
        return (x < 0 || y < 0 || x > mapSize - 1 || y > mapSize - 1);
    }
}
