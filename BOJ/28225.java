import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalCar = Integer.parseInt(st.nextToken());
        int flowerStreetLength = Integer.parseInt(st.nextToken());

        double minTime = Double.MAX_VALUE;
        int minCar = 0;
        for (int car = 1; car <= totalCar; car++) {
            st = new StringTokenizer(br.readLine());
            int observedLocation = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            double time = 1.0f * (flowerStreetLength - observedLocation) / speed;
            if (minTime > time) {
                minTime = time;
                minCar = car;
            }
        }

        sb.append(minCar);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
