import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String letters;

    public static void main(String[] args) throws Exception {
        letters = br.readLine();

        if ("fdsajkl;".equals(letters) || "jkl;fdsa".equals(letters)) {
            sb.append("in-out");
        } else if ("asdf;lkj".equals(letters) || ";lkjasdf".equals(letters)) {
            sb.append("out-in");
        } else if ("asdfjkl;".equals(letters)) {
            sb.append("stairs");
        } else if (";lkjfdsa".equals(letters)) {
            sb.append("reverse");
        } else {
            sb.append("molu");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
