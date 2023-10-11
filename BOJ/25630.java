import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());
        char[] sausages = br.readLine().toCharArray();

        int minMagic = 0;
        for (int i = 0; i < length / 2; i++) {
            minMagic += (sausages[i] != sausages[length - i - 1] ? 1 : 0);
        }
        sb.append(minMagic);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
