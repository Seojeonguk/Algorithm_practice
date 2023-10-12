import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String[] PRONOUNS = {"he", "she", "him", "her"};

    public static void main(String[] args) throws Exception {
        int wordCnt = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split(" ");

        int electricalShockCnt = 0;

        for (String word : words) {
            boolean isPronouns = false;
            for (String pronoun : PRONOUNS) {
                if (word.equals(pronoun)) {
                    isPronouns = true;
                }
            }
            if (isPronouns) {
                electricalShockCnt++;
            }
        }

        sb.append(electricalShockCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
