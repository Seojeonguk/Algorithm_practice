import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int COORDINATE_CNT = 3;

    public static void main(String[] args) throws Exception {
        Coordinate[] coordinates = new Coordinate[COORDINATE_CNT];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < COORDINATE_CNT; idx++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[idx] = new Coordinate(x, y);
        }

        double ans = -1.0f;
        if (!isOnLine(coordinates)) {
            double[] distance = new double[COORDINATE_CNT];
            distance[0] = coordinates[0].calDistance(coordinates[1]);
            distance[1] = coordinates[0].calDistance(coordinates[2]);
            distance[2] = coordinates[1].calDistance(coordinates[2]);
            Arrays.sort(distance);
            ans = Math.abs(distance[0] - distance[2]) * 2.0F;
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOnLine(Coordinate[] coordinates) {
        int ccw = (coordinates[1].getX() - coordinates[0].getX()) * (coordinates[2].getY() - coordinates[0].getY()) - (coordinates[2].getX() - coordinates[0].getX()) * (coordinates[1].getY() - coordinates[0].getY());
        return ccw == 0;
    }

    static class Coordinate {
        int x;
        int y;

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

        public double calDistance(Coordinate coordinate) {
            int xDistance = Math.abs(this.x - coordinate.getX());
            int yDistance = Math.abs(this.y - coordinate.getY());
            double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
            return distance;
        }
    }
}
