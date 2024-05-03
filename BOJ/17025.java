import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static final char EMPTY_SPACE = '.';

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int iceCreamSize = Integer.parseInt(br.readLine());

            char[][] iceCreams = new char[iceCreamSize + 2][iceCreamSize + 2];
            for (int row = 0; row < iceCreamSize + 2; row++) {
                for (int col = 0; col < iceCreamSize + 2; col++) {
                    iceCreams[row][col] = EMPTY_SPACE;
                }
            }

            for (int row = 1; row <= iceCreamSize; row++) {
                char[] rows = br.readLine().toCharArray();
                for (int col = 1; col <= iceCreamSize; col++) {
                    iceCreams[row][col] = rows[col - 1];
                }
            }

            boolean[][] visited = new boolean[iceCreamSize + 2][iceCreamSize + 2];
            int largestBlobArea = -1, smallestPerimeter = -1;

            for (int row = 1; row <= iceCreamSize; row++) {
                for (int col = 1; col <= iceCreamSize; col++) {
                    if (iceCreams[row][col] == '#' && !visited[row][col]) {
                        int[] blobs = calBlob(iceCreams, visited, row, col);

                        if (blobs[0] > largestBlobArea) {
                            largestBlobArea = blobs[0];
                            smallestPerimeter = blobs[1];
                        } else if (blobs[0] == largestBlobArea) {
                            smallestPerimeter = Math.min(smallestPerimeter, blobs[1]);
                        }
                    }
                }
            }

            sb.append(largestBlobArea).append(" ").append(smallestPerimeter);

            bw.write(sb.toString());
        }
    }

    public static int[] calBlob(char[][] iceCreams, boolean[][] visited, int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();

        visited[sx][sy] = true;
        q.add(new int[]{sx, sy});

        int blobArea = 0;
        int blobPerimeter = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            blobArea++;

            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (iceCreams[nx][ny] == '.') {
                    blobPerimeter++;
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return new int[]{blobArea, blobPerimeter};
    }
}
