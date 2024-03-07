import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer lakeInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(lakeInfo.nextToken());
        int colSize = Integer.parseInt(lakeInfo.nextToken());

        char[][] lakes = new char[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            lakes[row] = br.readLine().toCharArray();
        }

        ArrayList<Integer> waters = calWater(rowSize, colSize, lakes);
        Collections.sort(waters);

        sb.append(waters.size()).append("\n");
        for (int waterSize : waters) {
            sb.append(waterSize).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<Integer> calWater(int rowSize, int colSize, char[][] lakes) {
        ArrayList<Integer> waters = new ArrayList<>();

        boolean[][] visited = new boolean[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (lakes[row][col] == '1' && !visited[row][col]) {
                    int waterSize = 0;
                    Queue<int[]> q = new LinkedList<>();
                    visited[row][col] = true;
                    q.add(new int[]{row, col});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        waterSize++;

                        for (int i = 0; i < DIRS.length; i++) {
                            int nx = cur[0] + DIRS[i][0];
                            int ny = cur[1] + DIRS[i][1];

                            if (isOut(rowSize, colSize, nx, ny) || visited[nx][ny] || lakes[nx][ny] == '0') {
                                continue;
                            }
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }

                    waters.add(waterSize);
                }
            }
        }

        return waters;
    }

    public static boolean isOut(int rowSize, int colSize, int n, int m) {
        return (n < 0 || m < 0 || n > rowSize - 1 || m > colSize - 1);
    }
}
