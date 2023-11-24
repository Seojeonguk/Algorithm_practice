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

    static final int MAX = 10000000;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        long cnt = 0;

        int sqrt = (int) Math.sqrt(r) + 1;

        boolean[] visited = new boolean[sqrt];
        HashSet<Long> hs = new HashSet<>();
        for (int i = 2; (long) i * i <= r; i++) {
            if (visited[i]) {
                continue;
            }
            long tmp = i;
            while (tmp < r) {
                tmp *= i;

                if (l <= tmp && tmp <= r) {
                    hs.add(tmp);
                }
                if (tmp >= 100000000000000l / i) {
                    break;
                }
            }
            for (int j = i + i; j < sqrt; j += i) {
                visited[j] = true;
            }
        }

        sb.append(hs.size());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
