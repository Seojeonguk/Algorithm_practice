import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String catWord = br.readLine();

        int maxLength = 0, left = 0;
        HashMap<Character, Integer> alphabets = new HashMap<>();
        for (int right = 0; right < catWord.length(); right++) {
            char rightAlphabet = catWord.charAt(right);
            int value = 1;
            if (alphabets.containsKey(rightAlphabet)) {
                value += alphabets.get(rightAlphabet);
            }
            alphabets.put(rightAlphabet, value);
            while (!alphabets.isEmpty() && alphabets.size() > n) {
                char leftAlphabet = catWord.charAt(left++);
                value = alphabets.get(leftAlphabet);
                if (value == 1) {
                    alphabets.remove(leftAlphabet);
                } else {
                    alphabets.put(leftAlphabet, value - 1);
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        sb.append(maxLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
