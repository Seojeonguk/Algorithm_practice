import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String n;

    public static void main(String[] args) throws Exception {
        n = br.readLine();

        for (int i = n.length() - 3; i > 0; i -= 3) {
            n = n.substring(0, i) + "," + n.substring(i);
        }
        sb.append(n);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
