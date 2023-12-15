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
        int rotationSecond = Integer.parseInt(st.nextToken());
        int stopSecond = Integer.parseInt(st.nextToken());

        double rotationAnglePerSecond = 180.0f / rotationSecond;

        int rotation = stopSecond / rotationSecond;
        int rotationAngle = (int) Math.round((stopSecond % rotationSecond) * rotationAnglePerSecond);

        if (rotationAngle > 90) {
            rotation++;
        }

        sb.append(rotation % 2 > 0 ? "down" : "up");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
