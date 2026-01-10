import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();

        boolean isPalindrome = true;
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != str[str.length - i - 1]) {
                isPalindrome = false;
            }
        }

        sb.append(isPalindrome ? "beep" : "boop");

        bw.write(sb.toString());
        bw.flush();
    }
}
