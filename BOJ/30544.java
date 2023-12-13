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
        String[] strTime = br.readLine().split(":");
        int hour = Integer.parseInt(strTime[0]);
        int minute = Integer.parseInt(strTime[1]);

        int cuckooBirdSoundCount = Integer.parseInt(br.readLine());
        while (minute % 15 != 0) {
            minute++;
        }
        if (minute % 60 == 0) {
            if (minute == 60) {
                hour = (hour % 12) + 1;
            }
            cuckooBirdSoundCount -= hour;
            minute = 0;
        } else {
            cuckooBirdSoundCount--;
        }

        while (cuckooBirdSoundCount > 0) {
            minute += 15;
            if (minute % 60 == 0) {
                if (minute == 60) {
                    hour = (hour % 12) + 1;
                }
                cuckooBirdSoundCount -= hour;
                minute = 0;
            } else {
                cuckooBirdSoundCount--;
            }
        }

        sb.append(String.format("%02d:%02d", hour, minute));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
