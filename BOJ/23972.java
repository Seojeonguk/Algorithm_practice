import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long pay = Long.parseLong(st.nextToken());
        long ratio = Long.parseLong(st.nextToken());

        long minMoney = -1;
        if (ratio != 1) {
            minMoney = (pay * ratio) / (ratio - 1);
            if (pay % (ratio - 1) != 0) {
                minMoney++;
            }
        }
        sb.append(minMoney);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
