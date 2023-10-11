import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int fi = getLastValue(i);
            int fk = getLastValue(k);
            int f2k = getLastValue(2 * k);

            if (fi != fk && fi != f2k) {
                ans.add(i);
            }
        }
        sb.append(ans.size()).append("\n");
        for (int i : ans) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getLastValue(int x) {
        return x % 10;
    }
}
