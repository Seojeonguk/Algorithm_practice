import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();
        if (isOneCharacter(str)) {
            sb.append(-1);
        } else {
            sb.append(isPalindrome(str) ? str.length - 1 : str.length);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOneCharacter(char[] str) {
        for (int i = 1; i < str.length; i++) {
            if (str[0] != str[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(char[] str) {
        int left = 0, right = str.length - 1;
        while (left < right) {
            if (str[left++] != str[right--]) {
                return false;
            }
        }
        return true;
    }
}