import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int letterLength = Integer.parseInt(br.readLine());
        String previousWinner = br.readLine();
        String yourName = br.readLine();

        int moveJoystickCnt = 0;
        for (int i = 0; i < letterLength; i++) {
            int diff = Math.abs(previousWinner.charAt(i) - yourName.charAt(i));
            moveJoystickCnt += Math.min(26 - diff, diff);
        }

        sb.append(moveJoystickCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
