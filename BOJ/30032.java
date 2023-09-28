import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int row = 0; row < size; row++) {
            String word = br.readLine();
            for (int col = 0; col < size; col++) {
                sb.append(reverse(word.charAt(col), dir));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static char reverse(char c, int dir) {
        char ret = '0';
        if (dir == 1) {
            if (c == 'd') ret = 'q';
            else if (c == 'b') ret = 'p';
            else if (c == 'q') ret = 'd';
            else if (c == 'p') ret = 'b';
        } else {
            if (c == 'd') ret = 'b';
            else if (c == 'b') ret = 'd';
            else if (c == 'q') ret = 'p';
            else if (c == 'p') ret = 'q';
        }
        return ret;
    }
}
