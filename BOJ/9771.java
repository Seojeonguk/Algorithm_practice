import java.math.MathContext;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        String wordToSearch = br.readLine();
        int appearedCnt = 0;
        String str;

        while ((str = br.readLine()) != null) {
            appearedCnt += countWordOccurrences(str, wordToSearch);
        }

        sb.append(appearedCnt);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int countWordOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
