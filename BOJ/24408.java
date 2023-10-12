import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());

        int first = -1;
        while (length-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if (first == -1) {
                first = a;
            } else {
                if (a % first == 0) {
                    sb.append(a).append("\n");
                    first = -1;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
