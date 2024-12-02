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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int showerSeconds = Integer.parseInt(st.nextToken());
            int properTemperature = Integer.parseInt(st.nextToken());
            int currentTemperature = Integer.parseInt(st.nextToken());

            StringTokenizer changedTemperatures = new StringTokenizer(br.readLine());

            int discomfort = 0;
            for (int second = 0; second < showerSeconds; second++) {
                int changedTemperature = Integer.parseInt(changedTemperatures.nextToken());
                if (currentTemperature < properTemperature) {
                    currentTemperature += changedTemperature + Math.abs(currentTemperature - properTemperature);
                } else if (currentTemperature > properTemperature) {
                    currentTemperature += changedTemperature - Math.abs(currentTemperature - properTemperature);
                } else {
                    currentTemperature += changedTemperature;
                }

                discomfort += Math.abs(currentTemperature - properTemperature);
            }

            sb.append(discomfort);

            bw.write(sb.toString());
        }
    }
}
