import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int pebbleCnt = Integer.parseInt(br.readLine());

        sb.append(calCircumference(pebbleCnt));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calCircumference(int pebbleCnt) {
        int circumference = 4;
        if (pebbleCnt == 1) {
            return circumference;
        }

        int sqrt = (int) Math.sqrt(pebbleCnt);
        circumference = 2 * (sqrt + (pebbleCnt / (sqrt + 1)));
        if (sqrt * sqrt == pebbleCnt) {
            circumference = 4 * (sqrt - 1);
        }
        return circumference;
    }
}
