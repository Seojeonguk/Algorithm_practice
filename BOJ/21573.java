import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int temperature = Integer.parseInt(st.nextToken());
        int targetTemperature = Integer.parseInt(st.nextToken());

        String condition = br.readLine();

        int finalTemperature = temperature;
        if ("freeze".equals(condition)) {
            finalTemperature = Math.min(temperature, targetTemperature);
        } else if ("heat".equals(condition)) {
            finalTemperature = Math.max(temperature, targetTemperature);
        } else if ("auto".equals(condition)) {
            finalTemperature = targetTemperature;
        }

        sb.append(finalTemperature);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
