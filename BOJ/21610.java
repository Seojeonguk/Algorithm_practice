import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int mapSize = Integer.parseInt(st.nextToken());
        int movementInformationCnt = Integer.parseInt(st.nextToken());
        int[][] waters = new int[mapSize][mapSize];
        int[][] states = new int[mapSize][mapSize];
        boolean[][] existClouds = new boolean[mapSize][mapSize];

        ArrayList<Coordinate> clouds = new ArrayList<Coordinate>() {{
            add(new Coordinate(mapSize - 1, 0));
            add(new Coordinate(mapSize - 1, 1));
            add(new Coordinate(mapSize - 2, 0));
            add(new Coordinate(mapSize - 2, 1));
        }};

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                waters[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < movementInformationCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            for (int j = 0; j < mapSize; j++) {
                Arrays.fill(states[j], 0);
                Arrays.fill(existClouds[j], false);
            }

            ArrayList<Coordinate> addedCoordinates = new ArrayList<>();
            for (Coordinate cloud : clouds) {
                int nextX = (cloud.getX() + dirs[dir][0] * distance + 50 * mapSize) % mapSize;
                int nextY = (cloud.getY() + dirs[dir][1] * distance + 50 * mapSize) % mapSize;

                waters[nextX][nextY] += 1;
                addedCoordinates.add(new Coordinate(nextX, nextY));
                existClouds[nextX][nextY] = true;
            }

            clouds.clear();
            
            for (Coordinate addedCoordinate : addedCoordinates) {
                for (int j = 1; j < dirs.length; j += 2) {
                    int nextX = addedCoordinate.getX() + dirs[j][0];
                    int nextY = addedCoordinate.getY() + dirs[j][1];

                    if (isOut(mapSize, nextX, nextY)) {
                        continue;
                    }
                    states[addedCoordinate.getX()][addedCoordinate.getY()] += (waters[nextX][nextY] > 0 ? 1 : 0);
                }
            }

            for (int j = 0; j < mapSize; j++) {
                for (int k = 0; k < mapSize; k++) {
                    waters[j][k] += states[j][k];
                    if (existClouds[j][k] || waters[j][k] < 2) {
                        continue;
                    }
                    waters[j][k] -= 2;
                    clouds.add(new Coordinate(j, k));
                }
            }
        }

        int totalWaterAmount = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                totalWaterAmount += waters[i][j];
            }
        }
        sb.append(totalWaterAmount);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int mapSize, int x, int y) {
        return x < 0 || y < 0 || x > mapSize - 1 || y > mapSize - 1;
    }

    static class Coordinate {
        private int x;
        private int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
