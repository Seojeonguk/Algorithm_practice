import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int commandCnt = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        while (commandCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int value = Integer.parseInt(st.nextToken());
                s.add(value);
            } else if (command == 2) {
                sb.append(s.isEmpty() ? -1 : s.pop()).append("\n");
            } else if (command == 3) {
                sb.append(s.size()).append("\n");
            } else if (command == 4) {
                sb.append(s.isEmpty() ? 1 : 0).append("\n");
            } else if (command == 5) {
                sb.append(s.isEmpty() ? -1 : s.peek()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
