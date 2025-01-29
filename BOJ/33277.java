import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MILITARY_TIME = 24 * 60;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalDay = Integer.parseInt(st.nextToken());
            int completedDay = Integer.parseInt(st.nextToken());

            int totalMinutes = MILITARY_TIME * completedDay / totalDay;

            sb.append(String.format("%02d:%02d", totalMinutes / 60, totalMinutes % 60));

            bw.write(sb.toString());
        }
    }
}
