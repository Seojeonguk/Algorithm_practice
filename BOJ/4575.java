import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String message = br.readLine();
            if ("END".equals(message)) {
                break;
            }

            boolean isDuplicated = checkDuplicateCharacter(message);
            if (!isDuplicated) {
                sb.append(message).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkDuplicateCharacter(String str) {
        boolean[] isAppeared = new boolean[26];
        int strSize = str.length();

        for (int i = 0; i < strSize; i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            int idx = str.charAt(i) - 'A';
            if (isAppeared[idx]) {
                return true;
            }
            isAppeared[idx] = true;
        }

        return false;
    }
}
