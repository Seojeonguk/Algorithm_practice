import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int sweetcornPrice = Integer.parseInt(br.readLine());

        sb.append(sweetcornPrice * 10 / 11);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
