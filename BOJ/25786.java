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
        int v = Integer.parseInt(br.readLine());
        int v2 = Integer.parseInt(br.readLine());

        Stack<Integer> ans = new Stack<>();
        do {
            int a = v % 10;
            int b = v2 % 10;

            if ((a <= 2 && b <= 2) || (a >= 7 && b >= 7)) {
                ans.push(0);
            } else {
                ans.push(9);
            }
            v /= 10;
            v2 /= 10;
        } while (v > 0 || v2 > 0);

        while (!ans.isEmpty()) {
            sb.append(ans.pop());
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
