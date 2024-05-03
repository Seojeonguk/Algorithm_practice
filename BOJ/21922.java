import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String[] laboratorySize = br.readLine().split(" ");
            int rowSize = Integer.parseInt(laboratorySize[0]);
            int colSize = Integer.parseInt(laboratorySize[1]);

            Queue<int[]> q = new LinkedList<>();

            int[][] laboratory = new int[rowSize][colSize];
            boolean[][][] visited = new boolean[rowSize][colSize][DIRECTIONS.length];
            boolean[][] isWantedSeats = new boolean[rowSize][colSize];

            int wantedSeats = 0;

            for (int row = 0; row < rowSize; row++) {
                String[] rowData = br.readLine().split(" ");
                for (int col = 0; col < colSize; col++) {
                    laboratory[row][col] = Integer.parseInt(rowData[col]);
                    if (laboratory[row][col] == 9) {
                        wantedSeats++;
                        for (int dir = 0; dir < DIRECTIONS.length; dir++) {
                            q.add(new int[]{row, col, dir});
                            visited[row][col][dir] = true;
                        }
                    }
                }
            }

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curDir = cur[2];

                int nx = cur[0] + DIRECTIONS[curDir][0];
                int ny = cur[1] + DIRECTIONS[curDir][1];
                int nd = curDir;

                if (isOut(rowSize, colSize, nx, ny)) {
                    continue;
                }

                if ((laboratory[nx][ny] == 1 && nd % 2 == 1) || (laboratory[nx][ny] == 2 && nd % 2 == 0)) {
                    nd = (nd + 2) % DIRECTIONS.length;
                } else if (laboratory[nx][ny] == 3) {
                    nd = (nd / 2 * 2 + 1 - nd % 2);
                } else if (laboratory[nx][ny] == 4) {
                    nd = 3 - nd;
                }

                if (visited[nx][ny][nd]) {
                    continue;
                }

                visited[nx][ny][nd] = true;
                if (!isWantedSeats[nx][ny]) {
                    isWantedSeats[nx][ny] = true;
                    wantedSeats++;
                }

                q.add(new int[]{nx, ny, nd});
            }

            sb.append(wantedSeats);

            bw.write(sb.toString());
        }
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }
}
