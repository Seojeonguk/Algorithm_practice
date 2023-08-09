import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int humidityFactor = Integer.parseInt(br.readLine());
        int maximumWaitTime = Integer.parseInt(br.readLine());

        int firstTouchesGroundTime = -1;
        for (int time = 1; time <= maximumWaitTime; time++) {
            int altitude = -6 * time * time * time * time + humidityFactor * time * time * time + 2 * time * time + time;
            if (altitude <= 0) {
                firstTouchesGroundTime = time;
                break;
            }
        }

        if (firstTouchesGroundTime == -1) {
            sb.append("The balloon does not touch ground in the given time.");
        } else {
            sb.append("The balloon first touches ground at hour: ").append(firstTouchesGroundTime);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
