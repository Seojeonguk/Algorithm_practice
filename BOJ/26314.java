import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int nameCnt = Integer.parseInt(br.readLine());

        while (nameCnt-- > 0) {
            String name = br.readLine();

            int diffVowel = 0;
            for (int idx = 0; idx < name.length(); idx++) {
                diffVowel += (isVowel(name.charAt(idx)) ? 1 : -1);
            }

            sb.append(name).append("\n").append(diffVowel > 0 ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
