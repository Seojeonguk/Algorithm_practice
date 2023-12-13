import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int a = getValue(true);
        int b = getValue(false);

        sb.append("!").append(" ").append(a + b);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getValue(boolean isA) throws IOException {
        int ret = 0;

        for (int i = 1; i <= 9; i++) {
            System.out.println("? " + (isA ? "A " : "B ") + i);

            int answer = Integer.parseInt(br.readLine());
            if (answer == 1) {
                ret = i;
                break;
            }
        }

        return ret;
    }
}
