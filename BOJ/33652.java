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
        int recordingCnt = Integer.parseInt(br.readLine());
        long minTurnOffTime = Long.MAX_VALUE;

        while (recordingCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int isTurnOff = Integer.parseInt(st.nextToken());

            if (isTurnOff == 0) {
                minTurnOffTime = Math.min(minTurnOffTime, time);
            }
        }

        sb.append(minTurnOffTime == Long.MAX_VALUE ? -1 : minTurnOffTime).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
