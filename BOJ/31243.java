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

    static final int TOTAL_CAR = 3;

    public static void main(String[] args) throws Exception {
        int[] moveTimes = new int[TOTAL_CAR];
        for (int i = 0; i < TOTAL_CAR; i++) {
            st = new StringTokenizer(br.readLine());
            int startHour = Integer.parseInt(st.nextToken());
            int startMinute = Integer.parseInt(st.nextToken());

            int arrivalHour = Integer.parseInt(st.nextToken());
            int arrivalMinute = Integer.parseInt(st.nextToken());

            moveTimes[i] = calMoveTime(startHour * 60 + startMinute, arrivalHour * 60 + arrivalMinute);
        }

        Arrays.sort(moveTimes);

        sb.append(String.format("%d:%02d", moveTimes[0] / 60, moveTimes[0] % 60)).append("\n")
                .append(String.format("%d:%02d", moveTimes[2] / 60, moveTimes[2] % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMoveTime(int start, int arrival) {
        if (start > arrival) {
            arrival += 24 * 60;
        }

        return arrival - start;
    }
}
