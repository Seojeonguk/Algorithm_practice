import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int upperNine = (n / 100) * 100 + 99;
        int underNine = (Math.max(0, n / 100 - 1)) * 100 + 99;

        int upperDiff = Math.abs(upperNine - n);
        int underDiff = Math.abs(underNine - n);

        if (upperDiff > underDiff) {
            sb.append(underNine);
        } else {
            sb.append(upperNine);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
