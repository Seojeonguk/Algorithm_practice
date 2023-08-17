import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String currentTime = br.readLine();
        String dropSaltTime = br.readLine();

        int currentTotalSeconds = convertToSeconds(currentTime);
        int dropSaltTotalSeconds = convertToSeconds(dropSaltTime);

        if (currentTotalSeconds >= dropSaltTotalSeconds) {
            dropSaltTotalSeconds += 3600 * 24;
        }

        int requiredTotalSeconds = dropSaltTotalSeconds - currentTotalSeconds;
        sb.append(String.format("%02d:%02d:%02d", requiredTotalSeconds / 3600, requiredTotalSeconds % 3600 / 60, requiredTotalSeconds % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int convertToSeconds(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int seconds = Integer.parseInt(time.substring(6, 8));
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;

        return totalSeconds;
    }
}
