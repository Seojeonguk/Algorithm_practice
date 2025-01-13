import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int directorCnt = Integer.parseInt(br.readLine());
            int maximumMeetingDuration = Integer.parseInt(br.readLine());

            for (int time = 1; ; time++) {
                if (time * directorCnt + directorCnt - 1 > maximumMeetingDuration) {
                    sb.append(time - 1);
                    break;
                }
            }

            bw.write(sb.toString());
        }
    }
}
