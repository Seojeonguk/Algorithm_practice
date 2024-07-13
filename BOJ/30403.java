import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final char[] RAINBOWS = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int strLength = Integer.parseInt(br.readLine());
            char[] str = br.readLine().toCharArray();

            sb.append(canMakeRainbow(str));

            bw.write(sb.toString());
        }
    }

    public static String canMakeRainbow(char[] str) {
        boolean canMakeUpperRainbow = calMakeRainbow(str, 'A');
        boolean canMakeLowerRainbow = calMakeRainbow(str, 'a');

        String result = "NO!";

        if (canMakeUpperRainbow && canMakeLowerRainbow) {
            result = "YeS";
        } else if (canMakeUpperRainbow) {
            result = "YES";
        } else if (canMakeLowerRainbow) {
            result = "yes";
        }

        return result;
    }

    public static boolean calMakeRainbow(char[] str, char upper) {
        boolean[] isExist = new boolean[26];
        for (char c : str) {
            int idx = c - upper;
            if (idx < 0 || idx > 26) {
                continue;
            }

            isExist[idx] = true;
        }

        for (char c : RAINBOWS) {
            int idx = c - 'A';
            if (!isExist[idx]) {
                return false;
            }
        }

        return true;
    }
}
