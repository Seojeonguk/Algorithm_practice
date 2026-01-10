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
        String currentTime = br.readLine();
        String startTime = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int walkingTime = Integer.parseInt(st.nextToken());
        int decreaseRatio = Integer.parseInt(st.nextToken());

        int currentSeconds = convertTimeToSeconds(currentTime);
        int startSeconds = convertTimeToSeconds(startTime);

        if (startSeconds < currentSeconds) {
            sb.append(0);
        } else {
            int runningTime = walkingTime / 100 * (100 - decreaseRatio);
            if (startSeconds - currentSeconds < runningTime) {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static int convertTimeToSeconds(String currentTime) {
        String[] str = currentTime.split(":");
        int hours = Integer.parseInt(str[0]);
        int minutes = Integer.parseInt(str[1]);
        int seconds = Integer.parseInt(str[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}
