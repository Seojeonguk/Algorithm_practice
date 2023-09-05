import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int ALPHABET_CNT = 26;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        boolean[] isReplace = new boolean[ALPHABET_CNT];
        while (st.hasMoreTokens()) {
            char c = st.nextToken().charAt(0);
            isReplace[c - 'A'] = true;
        }

        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (Character.isUpperCase(c) && isReplace[c - 'A']) {
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
