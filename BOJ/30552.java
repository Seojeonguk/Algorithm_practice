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
        int n = Integer.parseInt(br.readLine());

        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("Present!")) {
                if (!dq.isEmpty()) {
                    dq.removeLast();
                }
            } else {
                dq.addLast(str);
            }
        }

        if (dq.isEmpty()) {
            sb.append("No Absences");
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
