import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        sb.append(sum / 2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
