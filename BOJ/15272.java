import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String word = br.readLine();

        if (word.contains("ss")) {
            sb.append("hiss");
        } else {
            sb.append("no hiss");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
