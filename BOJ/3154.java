import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[][] BUTTONS = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] setTimes = br.readLine().split(":");
        int setHour = Integer.parseInt(setTimes[0]);
        int setMinute = Integer.parseInt(setTimes[1]);

        int minEffort = Integer.MAX_VALUE;
        int minEffortHour = -1, minEffortMinute = -1;
        for (int hour = setHour; hour < 100; hour += 24) {
            for (int minute = setMinute; minute < 100; minute += 60) {
                int effort = calEffort(hour, minute);
                if (minEffort > effort) {
                    minEffort = effort;
                    minEffortHour = hour;
                    minEffortMinute = minute;
                }
            }
        }

        sb.append(String.format("%02d:%02d", minEffortHour, minEffortMinute));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calEffort(int h, int m) {
        int effort = 0;

        String pushH = String.format("%02d", h);
        String pushM = String.format("%02d", m);

        StringBuilder pushButtons = new StringBuilder();
        pushButtons.append(pushH).append(pushM);
        for (int idx = 0; idx < 3; idx++) {
            int prevNum = pushButtons.charAt(idx) - '0';
            int nextNum = pushButtons.charAt(idx + 1) - '0';

            int[] prevButton = BUTTONS[prevNum];
            int[] nextButton = BUTTONS[nextNum];

            effort += Math.abs(prevButton[0] - nextButton[0]) + Math.abs(prevButton[1] - nextButton[1]);
        }

        return effort;
    }
}
