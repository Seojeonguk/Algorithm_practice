import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            double[][] coordinates = new double[3][3];
            StringTokenizer peakInfo = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    coordinates[i][j] = Double.parseDouble(peakInfo.nextToken());
                }
            }

            double ab = dist(coordinates[0], coordinates[1]);
            double ac = dist(coordinates[0], coordinates[2]);
            double bc = dist(coordinates[1], coordinates[2]);

            if (pow(ac) > pow(ab) + pow(bc)) {
                sb.append(bc);
            } else if (pow(bc) > pow(ac) + pow(ab)) {
                sb.append(ac);
            } else {
                double s = (ab + ac + bc) / 2;
                double area = Math.sqrt(s * (s - ab) * (s - ac) * (s - bc));
                sb.append((area * 2) / ab);
            }

            bw.write(sb.toString());
        }
    }

    public static double dist(double[] a, double[] b) {
        return Math.sqrt(pow(a[0] - b[0]) + pow(a[1] - b[1]) + pow(a[2] - b[2]));
    }

    public static double pow(double x) {
        return x * x;
    }
}
