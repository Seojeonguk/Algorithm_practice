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

        int addLength = 3;
        int totalLength = 3;

        while (totalLength < n) {
            totalLength = 2 * totalLength + ++addLength;
        }

        while (true) {
            int prevTotalLength = (totalLength - addLength) / 2;

            if (n < prevTotalLength) {
                totalLength = prevTotalLength;
                addLength--;
            } else if (prevTotalLength + addLength < n) {
                n -= prevTotalLength + addLength;
                totalLength = prevTotalLength;
                addLength--;
            } else {
                n -= prevTotalLength;
                break;
            }
        }

        sb.append(n == 1 ? "m" : "o");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
