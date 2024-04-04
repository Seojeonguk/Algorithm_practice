import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer takeInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(takeInfo.nextToken());
        int colSize = Integer.parseInt(takeInfo.nextToken());

        int[][] currentTaken = new int[rowSize][colSize];
        int[][] targetTaken = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            StringTokenizer rowInfo = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                currentTaken[row][col] = Integer.parseInt(rowInfo.nextToken());
            }
        }

        for (int row = 0; row < rowSize; row++) {
            StringTokenizer rowInfo = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                targetTaken[row][col] = Integer.parseInt(rowInfo.nextToken());
            }
        }

        Loop1:
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (currentTaken[row][col] != targetTaken[row][col]) {
                    putVaccine(currentTaken, rowSize, colSize, row, col, targetTaken[row][col]);
                    break Loop1;
                }
            }
        }

        sb.append(isSame(currentTaken, targetTaken, rowSize, colSize) ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isSame(int[][] a, int[][] b, int rowSize, int colSize) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (a[row][col] != b[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isOut(int x, int y, int rowSize, int colSize) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }

    public static void putVaccine(int[][] taken, int rowSize, int colSize, int changedRow, int changedCol, int changedValue) {
        int original = taken[changedRow][changedCol];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{changedRow, changedCol});
        taken[changedRow][changedCol] = changedValue;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < DIRS.length; dir++) {
                int nx = cur[0] + DIRS[dir][0];
                int ny = cur[1] + DIRS[dir][1];

                if (isOut(nx, ny, rowSize, colSize) || taken[nx][ny] != original) {
                    continue;
                }

                taken[nx][ny] = changedValue;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
