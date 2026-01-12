import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hlo = Integer.parseInt(st.nextToken());
        int hhi = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int slo = Integer.parseInt(st.nextToken());
        int shi = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int vlo = Integer.parseInt(st.nextToken());
        int vhi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int red = Integer.parseInt(st.nextToken());
        int green = Integer.parseInt(st.nextToken());
        int blue = Integer.parseInt(st.nextToken());

        boolean isMaxRed = (green < red && blue < red);
        boolean isMaxGreen = (red < green && blue < green);
        boolean isMaxBlue = (red < blue && green < blue);

        double min = Math.min(red, Math.min(green, blue));
        double v = Math.max(red, Math.max(green, blue));
        double s = 255 * (v - min) / v;
        double h = 0;
        if (isMaxRed) {
            h = 60 * (green - blue) / (v - min);
        } else if (isMaxGreen) {
            h = 120 + 60 * (blue - red) / (v - min);
        } else if (isMaxBlue) {
            h = 240 + 60 * (red - green) / (v - min);
        }

        if (h < 0) {
            h += 360;
        }

        if (hlo <= h && h <= hhi && slo <= s && s <= shi && vlo <= v && v <= vhi) {
            sb.append("Lumi will like it.");
        } else {
            sb.append("Lumi will not like it.");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
