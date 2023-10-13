import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int[] appearedLetters = new int[26];
        String letters = br.readLine();
        for (int idx = 0; idx < letters.length(); idx++) {
            appearedLetters[letters.charAt(idx) - 'a']++;
        }

        boolean odd = false, even = false;
        for (int i = 0; i < 26; i++) {
            if (appearedLetters[i] == 0) {
                continue;
            }
            if (appearedLetters[i] % 2 == 0) even = true;
            else odd = true;
        }

        if (even && odd) {
            sb.append("0/1");
        } else if (even) {
            sb.append(0);
        } else if (odd) {
            sb.append(1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
