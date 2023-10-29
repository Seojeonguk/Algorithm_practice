import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int SIZE = 15;

    public static void main(String[] args) throws Exception {
        int cat = 0;

        for (int row = 0; row < SIZE; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < SIZE; col++) {
                char c = st.nextToken().charAt(0);
                if (c == 'w') {
                    cat = 1;
                } else if (c == 'b') {
                    cat = 2;
                } else if (c == 'g') {
                    cat = 3;
                }
            }
        }

        if (cat == 1) {
            sb.append("chunbae");
        } else if (cat == 2) {
            sb.append("nabi");
        } else if (cat == 3) {
            sb.append("yeongcheol");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
