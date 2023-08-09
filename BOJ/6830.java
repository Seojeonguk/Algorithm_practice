import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String coldestCity = "";
        int coldestTemperature = 300;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String city = st.nextToken();
            int temperature = Integer.parseInt(st.nextToken());

            if (temperature < coldestTemperature) {
                coldestTemperature = temperature;
                coldestCity = city;
            }

            if ("Waterloo".equals(city)) {
                break;
            }
        }

        sb.append(coldestCity);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
