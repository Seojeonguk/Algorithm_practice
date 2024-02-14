import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}, {1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cubeSize = Integer.parseInt(br.readLine());
        StringTokenizer startInfo = new StringTokenizer(br.readLine());
        StringTokenizer endInfo = new StringTokenizer(br.readLine());

        Coordinate startCoordinate = new Coordinate(startInfo);
        Coordinate endCoordinate = new Coordinate(endInfo);

        char[][][] matrix = new char[cubeSize + 1][cubeSize + 1][cubeSize + 1];
        for (int height = 1; height <= cubeSize; height++) {
            for (int row = 1; row <= cubeSize; row++) {
                char[] rows = br.readLine().toCharArray();
                for (int col = 1; col <= cubeSize; col++) {
                    matrix[row][col][height] = rows[col - 1];
                }
            }
        }

        boolean[][][] visited = new boolean[cubeSize + 1][cubeSize + 1][cubeSize + 1];
        visited[startCoordinate.x][startCoordinate.y][startCoordinate.z] = true;
        Queue<Coordinate> possiblePlaces = new LinkedList<>();
        possiblePlaces.add(startCoordinate);

        int smallestWingCnt = -1;
        while (!possiblePlaces.isEmpty()) {
            Coordinate current = possiblePlaces.poll();

            if (current.x == endCoordinate.x && current.y == endCoordinate.y && current.z == endCoordinate.z) {
                smallestWingCnt = current.cnt;
                break;
            }

            for (int i = 0; i < DIRS.length; i++) {
                int nextX = current.x + DIRS[i][0];
                int nextY = current.y + DIRS[i][1];
                int nextZ = current.z + DIRS[i][2];

                if (isOut(cubeSize, nextX, nextY, nextZ) || visited[nextX][nextY][nextZ] || matrix[nextX][nextY][nextZ] == '1') {
                    continue;
                }

                visited[nextX][nextY][nextZ] = true;
                possiblePlaces.add(new Coordinate(nextX, nextY, nextZ, current.cnt + 1));
            }
        }

        sb.append(smallestWingCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int n, int x, int y, int z) {
        return (x < 1 || y < 1 || z < 1 || x > n || y > n || z > n);
    }

    static class Coordinate {
        int x, y, z;
        int cnt;

        Coordinate(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }

        Coordinate(StringTokenizer info) {
            this.x = Integer.parseInt(info.nextToken());
            this.y = Integer.parseInt(info.nextToken());
            this.z = Integer.parseInt(info.nextToken());
            this.cnt = 0;
        }
    }
}
