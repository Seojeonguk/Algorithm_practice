import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String hillName = br.readLine();
        long minute = convertMinutes(br.readLine());

        if (isWeekend(br.readLine())) {
            minute *= 2;
        }

        int I70 = Integer.parseInt(br.readLine());
        if (I70 == 1) {
            minute *= 2;
        }

        int snow = Integer.parseInt(br.readLine());
        if (snow == 1) {
            minute *= 3;
        }

        int holiday = Integer.parseInt(br.readLine());
        if (holiday == 1) {
            minute *= 3;
        }

        sb.append(String.format("%d:%02d", minute / 60, minute % 60));

        bw.write(sb.toString());
        bw.flush();
    }

    public static long convertMinutes(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60L + minute;
    }

    public static boolean isWeekend(String day) {
        return ("sat".equals(day) || "sun".equals(day));
    }
}
