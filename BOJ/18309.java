import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String dayMeasuredTemperature = "";
        int maxTemperature = -51;
        int minTemperature = 51;
        while ((dayMeasuredTemperature = br.readLine()) != null) {
            String[] measuredTemperatures = dayMeasuredTemperature.split(" ");
            for (int idx = 1; idx < measuredTemperatures.length; idx++) {
                int temperature = Integer.parseInt(measuredTemperatures[idx]);
                maxTemperature = Math.max(maxTemperature, temperature);
                minTemperature = Math.min(minTemperature, temperature);
            }
        }
        sb.append(minTemperature).append(" ").append(maxTemperature);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
