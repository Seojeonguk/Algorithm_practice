import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int mostAppearedCnt = 0;
        int mostAppearedIdx = 0;
        int[] words = new int[26];
        for (int idx = 0; idx < size; idx++) {
            int alphabet = word.charAt(idx) - 'a';
            words[alphabet]++;
            if (words[alphabet] > mostAppearedCnt) {
                mostAppearedIdx = alphabet;
                mostAppearedCnt = words[alphabet];
            }
        }

        sb.append(String.format("%c %d", mostAppearedIdx + 'a', mostAppearedCnt));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
