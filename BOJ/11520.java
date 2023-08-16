import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int offsetIntoDigits = Integer.parseInt(st.nextToken());
            int digitToFind = Integer.parseInt(st.nextToken());

            sb.append(String.format("%d 5\n", digitToFind));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
