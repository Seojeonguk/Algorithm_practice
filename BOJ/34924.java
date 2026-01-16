import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        sb.append(canLeaveWord(str) ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean canLeaveWord(char[] str) {
        if (str.length % 2 == 1) {
            return false;
        }

        char[] PAUL = {'P', 'A', 'U', 'L'};
        int[] appeared = new int[4];
        int appearedIdx = 0;
        int PAULIdx = 0;
        for (int idx = 0; idx < str.length; idx++) {
            if (str[idx] == PAUL[PAULIdx]) {
                appeared[appearedIdx] = idx;
                PAULIdx++;
                appearedIdx++;

                if (PAULIdx == 4) {
                    break;
                }
            }
        }

        if (PAULIdx != 4) {
            return false;
        }

        if (appeared[0] % 2 == 1 || appeared[3] % 2 == 0) {
            return false;
        }

        for (int i = 1; i < 4; i++) {
            if ((appeared[i] - appeared[i - 1]) % 2 != 1) {
                return false;
            }
        }

        return true;
    }
}
