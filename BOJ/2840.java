import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalWheel = Integer.parseInt(st.nextToken());
        int rotationWheelCnt = Integer.parseInt(st.nextToken());


        int[] changedCharacters = new int[rotationWheelCnt];
        char[] stoppedCharacters = new char[rotationWheelCnt];

        for (int i = 0; i < rotationWheelCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int changedCharacter = Integer.parseInt(st.nextToken());
            char stoppedCharacter = st.nextToken().charAt(0);
            changedCharacters[i] = changedCharacter;
            stoppedCharacters[i] = stoppedCharacter;
        }

        char[] wheels = new char[totalWheel];
        Arrays.fill(wheels, '?');
        int idx = 0;
        boolean isLuckyWheel = true;
        for (int i = rotationWheelCnt - 1; i >= 0; i--) {
            if (wheels[idx] != '?' && wheels[idx] != stoppedCharacters[i]) {
                isLuckyWheel = false;
            }
            wheels[idx] = stoppedCharacters[i];
            idx = (idx + changedCharacters[i]) % totalWheel;
        }

        if (isLuckyWheel) {
            boolean isDuplication = false;
            boolean[] isAppeared = new boolean[26];
            for (int i = 0; i < totalWheel; i++) {
                if (wheels[i] != '?') {
                    idx = wheels[i] - 'A';
                    if (isAppeared[idx]) {
                        isDuplication = true;
                        break;
                    }
                    isAppeared[idx] = true;
                }
            }
            if (isDuplication) {
                sb.append("!");
            } else {
                for (int i = 0; i < totalWheel; i++) {
                    sb.append(wheels[i]);
                }
            }
        } else {
            sb.append("!");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
