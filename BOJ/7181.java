import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int WORD_LENGTH = 4;

    public static void main(String[] args) throws Exception {
        String secret = br.readLine();
        int[] appearanceSecret = new int[10];
        for (int idx = 0; idx < WORD_LENGTH; idx++) {
            appearanceSecret[secret.charAt(idx) - '0']++;
        }

        int lineCnt = Integer.parseInt(br.readLine());
        int[] appearanceLine = new int[10];
        for (int i = 0; i < lineCnt; i++) {
            Arrays.fill(appearanceLine, 0);
            String line = br.readLine();

            int rightPlace = 0;
            for (int idx = 0; idx < WORD_LENGTH; idx++) {
                appearanceLine[line.charAt(idx) - '0']++;
                rightPlace += (secret.charAt(idx) == line.charAt(idx) ? 1 : 0);
            }

            int rightNum = 0;
            for (int idx = 0; idx < 10; idx++) {
                rightNum += Math.min(appearanceSecret[idx], appearanceLine[idx]);
            }
            sb.append(String.format("%d %d\n", rightNum, rightPlace));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
