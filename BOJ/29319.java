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
        int n = Integer.parseInt(br.readLine());

        int[] rings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sb.append(Arrays.stream(rings).sum() - Arrays.stream(rings).max().getAsInt());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
