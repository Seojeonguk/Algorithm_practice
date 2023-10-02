import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int sectionCnt = Integer.parseInt(st.nextToken());
        int speed = Integer.parseInt(st.nextToken());

        int cur = 0;
        for (int section = 0; section < sectionCnt; section++) {
            int sledSpeed = Integer.parseInt(br.readLine());
            cur += sledSpeed;
            if (section != sectionCnt - 1 && cur > speed) {
                cur--;
            }
        }
        sb.append(cur);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
