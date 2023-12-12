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
        int k = Integer.parseInt(br.readLine());

        int a = 0;
        int i = 0;
        for (i = 0; i < 30; i++) {
            int b = (1 << (i + 1));
            a += b;
            if (k <= a) {
                break;
            }
        }

        k -= ((1 << (i + 1)) - 1);
        Stack<Integer> ans = new Stack<>();
        while (i-- >= 0) {
            ans.push(k % 2 == 0 ? 4 : 7);
            k /= 2;
        }

        while (!ans.isEmpty()) {
            sb.append(ans.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
