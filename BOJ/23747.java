import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final Map<Character, Integer> DIRECTION_INDEX = Map.of(
            'U', 0,
            'D', 1,
            'L', 2,
            'R', 3
    );
    static final char NOT_SIGHT = '#';
    static final char SIGHT = '.';

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer gridInfo = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(gridInfo.nextToken());
            int colSize = Integer.parseInt(gridInfo.nextToken());

            char[][] grid = new char[rowSize][colSize];
            char[][] sights = new char[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                grid[row] = br.readLine().toCharArray();
                Arrays.fill(sights[row], '#');
            }

            StringTokenizer startInfo = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(startInfo.nextToken()) - 1;
            int y = Integer.parseInt(startInfo.nextToken()) - 1;

            char[] commands = br.readLine().toCharArray();
            for (char command : commands) {
                if (command == 'W') {
                    putWard(rowSize, colSize, grid, sights, x, y);
                } else {
                    int dir = DIRECTION_INDEX.get(command);
                    x += DIRECTIONS[dir][0];
                    y += DIRECTIONS[dir][1];
                }
            }

            sights[x][y] = SIGHT;
            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if (!isOut(rowSize, colSize, nx, ny)) {
                    sights[nx][ny] = SIGHT;
                }
            }

            for (int row = 0; row < rowSize; row++) {
                sb.append(sights[row]).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static void putWard(int rowSize, int colSize, char[][] grid, char[][] sights, int sx, int sy) {
        if (grid[sx][sy] == SIGHT) {
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        sights[sx][sy] = SIGHT;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isOut(rowSize, colSize, nx, ny) || grid[sx][sy] != grid[nx][ny] || sights[nx][ny] == SIGHT) {
                    continue;
                }

                sights[nx][ny] = SIGHT;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }
}
