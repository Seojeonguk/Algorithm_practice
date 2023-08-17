import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        solve(list, n, n);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(List<Integer> list, int n, int prev) {
        if (n == 0) {
            list.stream().forEach(value -> {
                sb.append(value).append(" ");
            });
            sb.append("\n");
        }
        for (int i = n; i >= 1; i--) {
            if (prev < i) {
                continue;
            }
            List<Integer> nextList = new ArrayList<>(list);
            nextList.add(i);
            solve(nextList, n - i, i);
        }
    }
}
