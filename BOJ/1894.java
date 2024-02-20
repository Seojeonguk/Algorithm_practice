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

        String str = "";
        while ((str = br.readLine()) != null) {
            String[] strSplits = str.split(" ");
            Coordinate[] coordinates = new Coordinate[4];
            for (int i = 0; i < 4; i++) {
                double x = Double.parseDouble(strSplits[i * 2]);
                double y = Double.parseDouble(strSplits[i * 2 + 1]);
                coordinates[i] = new Coordinate(x, y);
            }

            Coordinate commonCoordinate = null;
            ArrayList<Coordinate> otherCoordinates = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (coordinates[i].isSame(coordinates[j])) {
                        commonCoordinate = coordinates[i];
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                if (!commonCoordinate.isSame(coordinates[i])) {
                    otherCoordinates.add(coordinates[i]);
                }
            }

            double x = otherCoordinates.get(0).x - (commonCoordinate.x - otherCoordinates.get(1).x);
            double y = otherCoordinates.get(0).y - (commonCoordinate.y - otherCoordinates.get(1).y);

            sb.append(String.format("%.03f %.03f\n", x, y));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Coordinate {
        double x, y;

        Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSame(Coordinate o) {
            return (this.x == o.x && this.y == o.y);
        }
    }
}
