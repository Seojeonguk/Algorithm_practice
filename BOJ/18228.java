import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int iceCnt = Integer.parseInt(br.readLine());
            int[] powerToBreakIce = new int[iceCnt];
            StringTokenizer powers = new StringTokenizer(br.readLine());

            int penguinPlace = -1;
            for (int idx = 0; idx < iceCnt; idx++) {
                int power = Integer.parseInt(powers.nextToken());
                powerToBreakIce[idx] = power;

                if (power == -1) {
                    penguinPlace = idx;
                }
            }

            int minPower = getMinPower(powerToBreakIce, 0, penguinPlace) + getMinPower(powerToBreakIce, penguinPlace + 1, iceCnt);
            sb.append(minPower);

            bw.write(sb.toString());
        }
    }

    public static int getMinPower(int[] powers, int start, int end) {
        int minPower = Integer.MAX_VALUE;
        for (int idx = start; idx < end; idx++) {
            minPower = Math.min(minPower, powers[idx]);
        }

        return minPower;
    }
}
