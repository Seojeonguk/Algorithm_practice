import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String movingInfo = br.readLine();
            if ("END".equals(movingInfo)) {
                break;
            }

            double[] destinationCoordinates = calDestination(movingInfo);
            double distance = Math.sqrt(destinationCoordinates[0] * destinationCoordinates[0] + destinationCoordinates[1] * destinationCoordinates[1]);
            sb.append(String.format("You can go to (%.3f,%.3f), the distance is %.3f steps.\n", destinationCoordinates[0], destinationCoordinates[1], distance));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static double[] calDestination(String movingInfo) {
        String[] directions = movingInfo.split("[,.]");
        int[] diff = new int[4];
        for (String directionInfo : directions) {
            int dirIdx = directionInfo.length() - 1 - (Character.isAlphabetic(directionInfo.charAt(directionInfo.length() - 2)) ? 1 : 0);
            int dir = getDir(directionInfo.substring(dirIdx));
            int moveDistance = Integer.parseInt(directionInfo.substring(0, dirIdx));

            diff[dir / 2] += (dir % 2 == 0 ? 1 : -1) * moveDistance;
        }

        double[] destination = new double[]{diff[0], diff[1]};

        double sqrt = Math.sqrt(diff[2] * diff[2] / 2.0);
        destination[0] += (diff[2] > 0 ? -1 : 1) * sqrt;
        destination[1] += (diff[2] > 0 ? 1 : -1) * sqrt;

        sqrt = Math.sqrt(diff[3] * diff[3] / 2.0);
        destination[0] += (diff[3] > 0 ? 1 : -1) * sqrt;
        destination[1] += (diff[3] > 0 ? 1 : -1) * sqrt;

        return destination;
    }

    public static int getDir(String direction) {
        int dir = -1;
        if ("E".equals(direction)) {
            dir = 0;
        } else if ("W".equals(direction)) {
            dir = 1;
        } else if ("N".equals(direction)) {
            dir = 2;
        } else if ("S".equals(direction)) {
            dir = 3;
        } else if ("NW".equals(direction)) {
            dir = 4;
        } else if ("SE".equals(direction)) {
            dir = 5;
        } else if ("NE".equals(direction)) {
            dir = 6;
        } else if ("SW".equals(direction)) {
            dir = 7;
        }

        return dir;
    }
}
