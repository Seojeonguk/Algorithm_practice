import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }

        while (arrayList.size() != 1) {
            for (int idx = (arrayList.size() - 1) / 2 * 2; idx >= 0; idx -= 2) {
                arrayList.remove(idx);
            }
        }
        sb.append(arrayList.get(0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
