import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int wordNum = Integer.parseInt(br.readLine());
            String[] words = new String[wordNum];
            for (int i = 0; i < wordNum; i++) {
                words[i] = br.readLine();
            }

            boolean canMakePalindrome = false;
            Loop1:
            for (int i = 0; i < wordNum; i++) {
                for (int j = 0; j < wordNum; j++) {
                    if (i == j) {
                        continue;
                    }
                    boolean isPalindrome = verifyPalindrome(words[i], words[j]);
                    if (isPalindrome) {
                        canMakePalindrome = true;
                        sb.append(words[i]).append(words[j]).append("\n");
                        break Loop1;
                    }
                }
            }

            if (!canMakePalindrome) {
                sb.append(0).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean verifyPalindrome(String a, String b) {
        String ab = a + b;
        int length = ab.length();
        for (int i = 0; i < length / 2; i++) {
            if (ab.charAt(i) != ab.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
