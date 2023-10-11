import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        int[] appearedCnt = new int[26];
        for (int idx = 0; idx < length; idx++) {
            appearedCnt[getIdx(word[idx])]++;
        }

        char[] needed = new char[]{'H', 'I', 'A', 'R', 'C'};
        int maxMakeEmoji = length;
        for (char c : needed) {
            int idx = getIdx(c);
            maxMakeEmoji = Math.min(maxMakeEmoji, appearedCnt[idx]);
        }
        sb.append(maxMakeEmoji);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getIdx(char c) {
        return c - 'A';
    }
}
