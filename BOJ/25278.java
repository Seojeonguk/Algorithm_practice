import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int oxygen = 0, ocean = 0, temperature = -30;

        int changeCnt = Integer.parseInt(br.readLine());

        while (changeCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            String changedEnvironment = st.nextToken();
            int changedSize = Integer.parseInt(st.nextToken());

            if ("temperature".equals(changedEnvironment)) {
                temperature += changedSize;
            } else if ("ocean".equals(changedEnvironment)) {
                ocean += changedSize;
            } else if ("oxygen".equals(changedEnvironment)) {
                oxygen += changedSize;
            }
        }

        sb.append(ocean >= 9 && oxygen >= 14 && temperature >= 8 ? "liveable" : "not liveable");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
