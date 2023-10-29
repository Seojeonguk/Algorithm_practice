import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String word = br.readLine();

        boolean isEasyWord = true;
        for (int idx = 0; idx < word.length() - 1; idx++) {
            char c = word.charAt(idx);
            if (!isVowel(c)) {
                isEasyWord &= isVowel(word.charAt(idx + 1));
            } else {
                isEasyWord &= !isVowel(word.charAt(idx + 1));
            }
        }

        sb.append(isEasyWord ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
