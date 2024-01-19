import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] splitTime = br.readLine().split(":");
        int[] dd = new int[3];
        int canHourCnt = 0;
        for (int i = 0; i < 3; i++) {
            dd[i] = Integer.parseInt(splitTime[i]);
            if (dd[i] >= 60) {
                canHourCnt = 0;
                break;
            }
            if (1 <= dd[i] && dd[i] <= 12) {
                canHourCnt++;
            }
        }

        sb.append(canHourCnt * 2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
