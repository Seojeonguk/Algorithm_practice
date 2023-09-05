import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String BUG = "BUG";

    public static void main(String[] args) throws Exception {
        String line;
        while ((line = br.readLine()) != null) {
            while (line.contains(BUG)) {
                line = line.replaceAll(BUG, "");
            }
            sb.append(line).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
