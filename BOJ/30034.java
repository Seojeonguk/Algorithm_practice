import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Set<Character> distinguished = new TreeSet<>();
        int letterDistinguishedCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (letterDistinguishedCnt-- > 0) {
            distinguished.add(st.nextToken().charAt(0));
        }

        int numberDistinguishedCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (numberDistinguishedCnt-- > 0) {
            distinguished.add(st.nextToken().charAt(0));
        }

        int mergerCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (mergerCnt-- > 0) {
            char c = st.nextToken().charAt(0);
            if (distinguished.contains(c)) {
                distinguished.remove(c);
            }
        }

        int wordLength = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int cnt = 0;
        for (int idx = 0; idx < wordLength; idx++) {
            char c = word.charAt(idx);
            if (distinguished.contains(c) || c == ' ') {
                if (cnt != 0) {
                    sb.append("\n");
                    cnt = 0;
                }
            } else {
                sb.append(word.charAt(idx));
                cnt++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
