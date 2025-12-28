import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int PASSED_TIME = 1800;
    private static int LAST_TIME = 300;
    private static int RUNIING_CNT = 4;
    private static String PASSED_RST = "Yes";
    private static String FAIL_RST = "No";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int totalTime = 0;
            for (int i = 0; i < RUNIING_CNT; i++) {
                int runningTime = Integer.parseInt(br.readLine());
                totalTime += runningTime;
            }
            totalTime += LAST_TIME;

            StringBuilder sb = new StringBuilder();
            sb.append(totalTime <= PASSED_TIME ? PASSED_RST : FAIL_RST);

            bw.write(sb.toString());
        }
    }
}
