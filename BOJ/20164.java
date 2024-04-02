import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int makeMinValue = Integer.MAX_VALUE;
    static int makeMaxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String originalValue = br.readLine();
        solve(originalValue, 0);

        sb.append(makeMinValue).append(" ").append(makeMaxValue);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calOddCnt(String str) {
        char[] s = str.toCharArray();
        int oddCnt = 0;
        for (int idx = 0; idx < s.length; idx++) {
            if ((s[idx] - '0') % 2 == 1) {
                oddCnt++;
            }
        }

        return oddCnt;
    }

    public static void solve(String value, int oddCnt) {
        int currentOddCnt = calOddCnt(value);
        int valueLength = value.length();

        if (valueLength == 1) {
            makeMinValue = Math.min(makeMinValue, oddCnt + currentOddCnt);
            makeMaxValue = Math.max(makeMaxValue, oddCnt + currentOddCnt);
        } else if (valueLength == 2) {
            int next = Integer.parseInt(value.substring(0, 1)) + Integer.parseInt(value.substring(1));
            solve(String.valueOf(next), oddCnt + currentOddCnt);
        } else {
            for (int i = 1; i < valueLength; i++) {
                for (int j = i + 1; j < valueLength; j++) {
                    int a = Integer.parseInt(value.substring(0, i));
                    int b = Integer.parseInt(value.substring(i, j));
                    int c = Integer.parseInt(value.substring(j));

                    solve(String.valueOf(a + b + c), oddCnt + currentOddCnt);
                }
            }
        }
    }
}
