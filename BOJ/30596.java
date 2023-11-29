import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int[] lengths = new int[4];
        for (int i = 0; i < 4; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
        }

        sb.append(lengths[0] * lengths[2]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
