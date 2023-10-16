import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int[] appearedLetters = new int[26];
        for (int idx = 0; idx < str.length(); idx++) {
            appearedLetters[str.charAt(idx) - 'a']++;
        }

        boolean appearedOddLetter = false;
        boolean appearedEvenLetter = false;
        for (int idx = 0; idx < 26; idx++) {
            if (appearedLetters[idx] == 0) {
                continue;
            }
            if (appearedLetters[idx] % 2 == 0) {
                appearedEvenLetter = true;
            } else {
                appearedOddLetter = true;
            }
        }
        if (appearedEvenLetter && appearedOddLetter) {
            sb.append(2);
        } else if (appearedOddLetter) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
