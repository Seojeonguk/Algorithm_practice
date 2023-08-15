import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        sb.append(sum)
                .append("\n")
                .append(sum * sum)
                .append("\n")
                .append(sum * sum);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
