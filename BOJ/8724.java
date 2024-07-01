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

            int boardCnt = Integer.parseInt(br.readLine());
            int[] existPins = new int[boardCnt];

            StringTokenizer pins = new StringTokenizer(br.readLine());
            for (int i = 0; i < boardCnt; i++) {
                existPins[i] = Integer.parseInt(pins.nextToken());
            }

            sb.append(getJumpLength(existPins));

            bw.write(sb.toString());
        }
    }

    public static int getJumpLength(int[] existPins) {
        int maxJumpLength = 0;
        int jumpLength = 0;

        for (int i = 0; i < existPins.length; i++) {
            if (existPins[i] == 0) {
                jumpLength = 0;
            } else {
                jumpLength++;
                maxJumpLength = Math.max(maxJumpLength, jumpLength);
            }
        }

        return maxJumpLength;
    }
}
