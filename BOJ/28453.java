import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int levelCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < levelCnt; idx++) {
            int level = Integer.parseInt(st.nextToken());
            int section = getSection(level);
            sb.append(section).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getSection(int level) {
        if (level < 250) return 4;
        else if (level < 275) return 3;
        else if (level < 300) return 2;
        return 1;
    }
}