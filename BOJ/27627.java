import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        for (int i = 1; i < str.length(); i++) {
            String subStr1 = str.substring(0, i);
            String subStr2 = str.substring(i);

            if (isPalindrome(subStr1) && isPalindrome(subStr2)) {
                sb.append(subStr1).append(" ").append(subStr2);
                break;
            }
        }

        if (sb.length() == 0) {
            sb.append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPalindrome(String str) {
        int halfSize = str.length() / 2;
        for (int i = 0; i < halfSize; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
