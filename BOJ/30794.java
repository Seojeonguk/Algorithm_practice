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

        int level = Integer.parseInt(st.nextToken());
        String result = st.nextToken();

        int score = 0;
        if ("bad".equals(result)) {
            score = 200 * level;
        } else if ("cool".equals(result)) {
            score = 400 * level;
        } else if ("great".equals(result)) {
            score = 600 * level;
        } else if ("perfect".equals(result)) {
            score = 1000 * level;
        }

        sb.append(score);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
