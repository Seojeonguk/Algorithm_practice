import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 5; i++) {
            for (int j = 0; j < n * 5; j++) {
                sb.append((n <= j && j < 4 * n) && ((i < n) || (n * 2 <= i && i < n * 3) || (n * 4 <= i)) ? " " : "@");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
