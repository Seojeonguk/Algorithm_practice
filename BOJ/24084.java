import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int wordLength = Integer.parseInt(br.readLine());
        String word = br.readLine();

        for (int idx = 0; idx < wordLength - 1; idx++) {
            if (word.charAt(idx + 1) == 'J') {
                sb.append(word.charAt(idx)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
