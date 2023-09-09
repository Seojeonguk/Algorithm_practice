import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String LABEL = "WelcomeToSMUPC";

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine()) - 1;
        sb.append(LABEL.charAt(n % LABEL.length()));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
