import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer bugInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(bugInfo.nextToken());
        int colSize = Integer.parseInt(bugInfo.nextToken());

        boolean[][] visited = new boolean[rowSize][colSize];
        int curX = 0, curY = 0, dir = 0, turnCnt = 0;
        visited[curX][curY] = true;

        while (true) {
            int nextX = curX + DIRS[dir][0];
            int nextY = curY + DIRS[dir][1];

            if (isOut(rowSize, colSize, nextX, nextY) || visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
                nextX = curX + DIRS[dir][0];
                nextY = curY + DIRS[dir][1];

                if (visited[nextX][nextY]) {
                    break;
                }
                turnCnt++;
            }

            visited[nextX][nextY] = true;
            curX = nextX;
            curY = nextY;
        }

        sb.append(turnCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int rowSize, int colSize, int n, int m) {
        return (n < 0 || m < 0 || n > rowSize - 1 || m > colSize - 1);
    }
}
