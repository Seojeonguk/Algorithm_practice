import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            char[] str = br.readLine().toCharArray();
            int[] appeared = new int[26];
            for (int idx = 0; idx < str.length; idx++) {
                appeared[str[idx] - 'a']++;
            }

            char[] cur = new char[str.length];
            solve(appeared, sb, cur, 0, str.length);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int[] appeared, StringBuilder sb, char[] cur, int length, int strLength) {
        if (length == strLength) {
            sb.append(cur).append("\n");
            return;
        }

        for (int idx = 0; idx < 26; idx++) {
            if (appeared[idx] > 0) {
                appeared[idx]--;
                cur[length] = (char) ('a' + idx);
                solve(appeared, sb, cur, length + 1, strLength);
                appeared[idx]++;
            }
        }
    }
}
