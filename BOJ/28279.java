import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int commandCnt = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int value = Integer.parseInt(st.nextToken());
                dq.addFirst(value);
            } else if (command == 2) {
                int value = Integer.parseInt(st.nextToken());
                dq.addLast(value);
            } else if (command == 3) {
                sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
            } else if (command == 4) {
                sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
            } else if (command == 5) {
                sb.append(dq.size()).append("\n");
            } else if (command == 6) {
                sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            } else if (command == 7) {
                sb.append(dq.isEmpty() ? -1 : dq.getFirst()).append("\n");
            } else if (command == 8) {
                sb.append(dq.isEmpty() ? -1 : dq.getLast()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
