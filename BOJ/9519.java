import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int y = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int repeat = getRepeat(word);
        y = y % repeat;

        String prevWord = getPrevWord(word, y);
        sb.append(prevWord);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getRepeat(String originalWord) {
        int repeat = 0;
        String word = originalWord;
        while (true) {
            word = getPrevFirstWord(word);
            repeat++;
            if (originalWord.equals(word)) {
                break;
            }
        }

        return repeat;
    }

    public static String getPrevWord(String originalWord, int n) {
        String word = originalWord;
        for (int i = 0; i < n; i++) {
            word = getPrevFirstWord(word);
        }
        return word;
    }

    public static String getPrevFirstWord(String originalWord) {
        String word = originalWord;
        for (int j = 0; j < word.length() / 2; j++) {
            int idx = word.length() - word.length() % 2 - 1 - 2 * j;
            word = word.substring(0, idx) + (idx == word.length() - 1 ? "" : word.substring(idx + 1)) + word.charAt(idx);
        }
        return word;
    }
}
