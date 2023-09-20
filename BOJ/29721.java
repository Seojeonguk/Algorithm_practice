import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[][] DIRS = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int chessSize = Integer.parseInt(st.nextToken());
        int dabbabaCnt = Integer.parseInt(st.nextToken());
        HashSet<Long> dabbabas = new HashSet<>();
        while (dabbabaCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken()) - 1;
            long m = Long.parseLong(st.nextToken()) - 1;
            dabbabas.add(n * chessSize + m);
        }

        HashSet<Long> possibleNextPlace = new HashSet<>();
        for (long dabbaba : dabbabas) {
            long n = dabbaba / chessSize;
            long m = dabbaba % chessSize;

            for (int dir = 0; dir < DIRS.length; dir++) {
                long nx = n + DIRS[dir][0];
                long ny = m + DIRS[dir][1];

                if (nx < 0 || ny < 0 || nx > chessSize - 1 || ny > chessSize - 1 || dabbabas.contains(nx * chessSize + ny)) {
                    continue;
                }
                possibleNextPlace.add(nx * chessSize + ny);
            }
        }
        sb.append(possibleNextPlace.size());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
