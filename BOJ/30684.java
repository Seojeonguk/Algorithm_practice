import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int personCnt = Integer.parseInt(br.readLine());
            PriorityQueue<String> candidates = new PriorityQueue<>();
            for (int i = 0; i < personCnt; i++) {
                String name = br.readLine();
                if (name.length() == 3) {
                    candidates.add(name);
                }
            }

            sb.append(candidates.poll());

            bw.write(sb.toString());
        }
    }
}
