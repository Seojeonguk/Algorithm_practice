import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int memoryHandleCnt = Integer.parseInt(st.nextToken());
            int kthHandle = Integer.parseInt(st.nextToken());

            PriorityQueue<String> handles = new PriorityQueue<>();
            for (int i = 0; i < memoryHandleCnt; i++) {
                String handle = br.readLine();
                handles.add(handle);
            }

            for (int i = 1; i < kthHandle; i++) {
                handles.poll();
            }

            sb.append(handles.poll());

            bw.write(sb.toString());
        }
    }
}
