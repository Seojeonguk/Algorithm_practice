import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int COORDINATE_COUNT = 3;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int processCnt = Integer.parseInt(br.readLine());

        while (processCnt-- > 0) {
            String currentStartSystemName = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            double[] currentStartSystemCoordinates = new double[COORDINATE_COUNT];
            for (int i = 0; i < COORDINATE_COUNT; i++) {
                currentStartSystemCoordinates[i] = Double.parseDouble(st.nextToken());
            }

            String destinationStartSystemName = br.readLine();
            st = new StringTokenizer(br.readLine());
            double[] destinationStartSystemCoordinates = new double[COORDINATE_COUNT];
            for (int i = 0; i < COORDINATE_COUNT; i++) {
                destinationStartSystemCoordinates[i] = Double.parseDouble(st.nextToken());
            }

            double distance = calDistance(currentStartSystemCoordinates, destinationStartSystemCoordinates);

            sb.append(String.format("%s to %s: %.2f\n", currentStartSystemName, destinationStartSystemName, distance));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static double calDistance(double[] current, double[] destination) {
        double sums = 0;

        for (int i = 0; i < current.length; i++) {
            double diff = current[i] - destination[i];
            sums += diff * diff;
        }

        return Math.sqrt(sums);
    }
}
