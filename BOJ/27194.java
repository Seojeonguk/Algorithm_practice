import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int distance = Integer.parseInt(st.nextToken());
        int meetingMinute = Integer.parseInt(st.nextToken());

        int parkDistance = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int speedBeforePark = Integer.parseInt(st.nextToken());
        int speedInPark = Integer.parseInt(st.nextToken());

        double beforeParkTime = 1.0f * parkDistance / (speedBeforePark * 60);
        double parkTime = 1.0f * (distance - parkDistance) / (speedInPark * 60);

        int arrivalTime = (int) Math.ceil(beforeParkTime + parkTime);

        if (arrivalTime <= meetingMinute) {
            sb.append(0);
        } else {
            sb.append(arrivalTime - meetingMinute);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
