import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] steps = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                steps[i][j] = Integer.parseInt(br.readLine());
            }
        }

        int time = Integer.parseInt(br.readLine());
        int nikkyStep = calStep(steps[0], time);
        int byronStep = calStep(steps[1], time);

        if (nikkyStep > byronStep) {
            sb.append("Nikky");
        } else if (nikkyStep < byronStep) {
            sb.append("Byron");
        } else {
            sb.append("Tied");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calStep(int[] steps, int time) {
        int stepDir = 0;
        int curTime = 0;
        int step = 0;
        int stepCnt = 0;

        while (curTime != time) {
            step += (stepDir == 0 ? 1 : -1);
            stepCnt++;
            if (stepCnt == steps[stepDir]) {
                stepDir = 1 - stepDir;
                stepCnt = 0;
            }
            curTime++;
        }

        return step;
    }
}
