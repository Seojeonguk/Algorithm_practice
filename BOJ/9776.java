import java.math.MathContext;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static double PI = 3.14159;

    public static void main(String[] args) throws Exception {
        int figureCnt = Integer.parseInt(br.readLine());

        double maxVolume = 0;
        for (int i = 0; i < figureCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String letter = st.nextToken();

            if ("S".equals(letter)) {
                double r = Double.parseDouble(st.nextToken());
                double volume = 4.0f / 3.0f * PI * r * r * r;
                maxVolume = Math.max(maxVolume, volume);
            } else if ("C".equals(letter)) {
                double r = Double.parseDouble(st.nextToken());
                double h = Double.parseDouble(st.nextToken());
                double volume = 1.0f / 3.0f * PI * r * r * h;
                maxVolume = Math.max(maxVolume, volume);
            } else if ("L".equals(letter)) {
                double r = Double.parseDouble(st.nextToken());
                double h = Double.parseDouble(st.nextToken());
                double volume = PI * r * r * h;
                maxVolume = Math.max(maxVolume, volume);
            }
        }

        sb.append(String.format("%.3f", maxVolume));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
