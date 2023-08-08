import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int command, dir;
    static int[] addedDir = {1, 2, 3};
    static char[] directions = {'N', 'E', 'S', 'W'};

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            command = Integer.parseInt(br.readLine());
            dir = (dir + command) % 4;
        }

        sb.append(directions[dir]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
