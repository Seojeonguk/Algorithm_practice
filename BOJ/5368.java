import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            int gridSize = Integer.parseInt(br.readLine());

            char[][] grids = new char[gridSize][gridSize];
            ArrayList<int[]> planets = new ArrayList<>();
            int shipX = -1, shipY = -1;
            for (int row = 0; row < gridSize; row++) {
                grids[row] = br.readLine().toCharArray();
                for (int col = 0; col < gridSize; col++) {
                    if (grids[row][col] == 's') {
                        shipX = row;
                        shipY = col;
                    } else if (grids[row][col] == 'p') {
                        planets.add(new int[]{row, col});
                    }
                }
            }

            int minDistancePlanetIdx = calMinDistancePlanetIdx(shipX, shipY, planets);
            int minPlanetX = planets.get(minDistancePlanetIdx)[0];
            int minPlanetY = planets.get(minDistancePlanetIdx)[1];
            double distance = calDistance(shipX, shipY, minPlanetX, minPlanetY);

            sb.append(String.format("(%d,%d):(%d,%d):%.2f\n", shipX, shipY, minPlanetX, minPlanetY, distance));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMinDistancePlanetIdx(int x, int y, ArrayList<int[]> planets) {
        int idx = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < planets.size(); i++) {
            int[] planet = planets.get(i);
            double distance = calDistance(x, y, planet[0], planet[1]);
            if (minDistance > distance) {
                minDistance = distance;
                idx = i;
            }
        }

        return idx;
    }

    public static double calDistance(int x, int y, int planetX, int planetY) {
        int xDiff = x - planetX;
        int yDiff = y - planetY;

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
