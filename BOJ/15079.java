import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int instructionCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());

        for (int i = 0; i < instructionCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            double[] coordinate = convertFromDirectionToCoordinate(dir, distance);
            x += coordinate[0];
            y += coordinate[1];
        }

        sb.append(String.format("%.7f %.7f\n", x, y));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static double[] convertFromDirectionToCoordinate(String dir, int distance) {
        double[] coordinate = {0, 0};
        if (dir.length() == 2) {
            double sideLength = calSideLength(distance);
            coordinate[0] = sideLength;
            coordinate[1] = sideLength;
            if (dir.contains("S")) {
                coordinate[1] = -coordinate[1];
            }
            if (dir.contains("W")) {
                coordinate[0] = -coordinate[0];
            }
        } else {
            if ("N".equals(dir)) {
                coordinate[1] = distance;
            } else if ("E".equals(dir)) {
                coordinate[0] = distance;
            } else if ("S".equals(dir)) {
                coordinate[1] = -distance;
            } else if ("W".equals(dir)) {
                coordinate[0] = -distance;
            }
        }

        return coordinate;
    }

    public static double calSideLength(int distance) {
        return Math.sqrt(1.0f * distance * distance/2);
    }
}
