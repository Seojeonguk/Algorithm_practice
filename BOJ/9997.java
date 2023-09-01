import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int wordCnt = Integer.parseInt(br.readLine());
        int[] wordTobits = new int[wordCnt];
        for (int idx = 0; idx < wordCnt; idx++) {
            int bits = 0;
            String word = br.readLine();
            for (int wordIdx = 0; wordIdx < word.length(); wordIdx++) {
                bits |= (1 << (word.charAt(wordIdx) - 'a'));
            }
            wordTobits[idx] = bits;
        }

        int possibleMakeSentence = solve(wordTobits, 0, 0);
        sb.append(possibleMakeSentence);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int[] wordToBits, int idx, int bit) {
        if (idx == wordToBits.length) {
            return bit == ((1 << 26) - 1) ? 1 : 0;
        }
        int ret = 0;
        ret += solve(wordToBits, idx + 1, bit | wordToBits[idx]);
        ret += solve(wordToBits, idx + 1, bit);

        return ret;
    }
}
