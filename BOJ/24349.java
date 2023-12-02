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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) - 1;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int moveDistance = 0;
        if (n > 0) {
            moveDistance += Math.min(a, b);
            n--;
            if (n > 0) {
                if (a <= b) {
                    moveDistance += Math.min(a, c) * n;
                } else {
                    moveDistance += Math.min(b, c) * n;
                }
            }
        }

        sb.append(moveDistance / 100).append(" ").append(moveDistance % 100);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
