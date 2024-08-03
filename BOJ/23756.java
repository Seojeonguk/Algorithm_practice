import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int targetKnobAngleCnt = Integer.parseInt(br.readLine());
            int[] targetKnobAngles = new int[targetKnobAngleCnt + 1];
            targetKnobAngles[0] = Integer.parseInt(br.readLine());
            for (int i = 1; i <= targetKnobAngleCnt; i++) {
                targetKnobAngles[i] = Integer.parseInt(br.readLine());
            }

            sb.append(minKnobAngle(targetKnobAngles));

            bw.write(sb.toString());
        }
    }

    public static int minKnobAngle(int[] targetKnobAngles) {
        int knobAngle = 0;

        for (int i = 0; i < targetKnobAngles.length - 1; i++) {
            int angle = Math.abs(targetKnobAngles[i] - targetKnobAngles[i + 1]);
            knobAngle += Math.min(angle, 360 - angle);
        }

        return knobAngle;
    }
}
