import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static final int MAX_KEY_PRESSED_TIME = 1000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            int[] pressedKeys = new int[MAX_KEY_PRESSED_TIME + 2];
            for (int tc = 0; tc < testCase; tc++) {
                Arrays.fill(pressedKeys, 0);
                int pressedKeyCnt = Integer.parseInt(br.readLine());

                for (int i = 0; i < pressedKeyCnt; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String pressedkey = st.nextToken();
                    int pressedTime = Integer.parseInt(st.nextToken());
                    int unPressedTime = Integer.parseInt(st.nextToken());

                    pressedKeys[pressedTime + 1]++;
                    pressedKeys[unPressedTime + 1]--;
                }

                for (int i = 1; i < MAX_KEY_PRESSED_TIME + 1; i++) {
                    pressedKeys[i] += pressedKeys[i - 1];
                    if (pressedKeys[i] > 0) {
                        sb.append((char) ('A' + pressedKeys[i] - 1));
                    }
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
