import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int bufferSize = Integer.parseInt(br.readLine());
        Queue<Integer> buffer = new LinkedList<>();
        while (true) {
            int packet = Integer.parseInt(br.readLine());
            if (packet == -1) {
                break;
            }
            if (packet > 0) {
                if (buffer.size() < bufferSize) {
                    buffer.add(packet);
                }
            } else {
                buffer.poll();
            }
        }

        if (buffer.isEmpty()) {
            sb.append("empty");
        }

        while (!buffer.isEmpty()) {
            sb.append(buffer.poll()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
