import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tinesHeight = Integer.parseInt(br.readLine());
        int tinesSpacing = Integer.parseInt(br.readLine());
        int handleLength = Integer.parseInt(br.readLine());

        for (int i = 0; i < tinesHeight; i++) {
            for (int j = 0; j < 2 * tinesSpacing + 3; j++) {
                if (j == 0 || j == tinesSpacing + 1 || j == 2 * tinesSpacing + 2) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = 0; i < 2 * tinesSpacing + 3; i++)
            sb.append("*");
        sb.append("\n");

        for (int i = 0; i < handleLength; i++) {
            for (int j = 0; j < tinesSpacing + 1; j++)
                sb.append(" ");
            sb.append("*\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
