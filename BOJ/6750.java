import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String letters = br.readLine();
        boolean canSign = true;

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            if (letter != 'I' && letter != 'O' && letter != 'S' && letter != 'H' && letter != 'Z' && letter != 'X' && letter != 'N') {
                canSign = false;
            }
        }
        sb.append((canSign ? "YES" : "NO"));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
