import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int COMPRESS_SIZE = 1860000;

    public static void main(String[] args) throws Exception {
        for (int cases = 1; ; cases++) {
            st = new StringTokenizer(br.readLine());
            int par = Integer.parseInt(st.nextToken());
            int neededJohnStrokeCnt = Integer.parseInt(st.nextToken());

            if (par == 0 && neededJohnStrokeCnt == 0) {
                break;
            }

            sb.append("Hole #").append(cases).append("\n");

            if (neededJohnStrokeCnt == 1) {
                sb.append("Hole-in-one.\n\n");
            } else if (par - 1 == neededJohnStrokeCnt) {
                sb.append("Birdie.\n\n");
            } else if (par + 1 == neededJohnStrokeCnt) {
                sb.append("Bogey.\n\n");
            } else if (par - 2 == neededJohnStrokeCnt) {
                sb.append("Eagle.\n\n");
            } else if (par - 3 >= neededJohnStrokeCnt) {
                sb.append("Double eagle.\n\n");
            } else if (par + 2 <= neededJohnStrokeCnt) {
                sb.append("Double Bogey.\n\n");
            } else {
                sb.append("Par.\n\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
