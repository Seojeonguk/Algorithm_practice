import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final String TARGET_STR = "eagle";

    public static void main(String[] args) throws Exception {
        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int minChangedCnt = 5;
        for (int idx = 0; idx <= strLength - 5; idx++) {
            int changedCnt = calChangedCnt(str.substring(idx, idx + 5), TARGET_STR);
            minChangedCnt = Math.min(minChangedCnt, changedCnt);
        }

        sb.append(minChangedCnt);

        bw.write(sb.toString());
        bw.flush();
    }

    public static int calChangedCnt(String str, String target) {
        char[] strChars = str.toCharArray();
        char[] targetChars = target.toCharArray();

        int length = strChars.length;

        int diffCnt = 0;
        for (int idx = 0; idx < length; idx++) {
            if (strChars[idx] != targetChars[idx]) {
                diffCnt++;
            }
        }

        return diffCnt;
    }
}
