import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final double PI = 3.1415926535897932384626433;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer propertyDescriptions = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(propertyDescriptions.nextToken());
            double y = Double.parseDouble(propertyDescriptions.nextToken());

            if (x == 0 && y == 0) {
                break;
            }

            double rPow = 100.0f / PI;
            double distancePow = x * x + y * y;

            int hour = 1;
            while (rPow * hour < distancePow) {
                hour++;
            }
            sb.append(String.format("The property will be flooded in hour %d.\n", hour));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
