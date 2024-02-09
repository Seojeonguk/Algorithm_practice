import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int arrSize = Integer.parseInt(st.nextToken());
            if (arrSize == 0) {
                break;
            }

            int prev = 0;
            for (int i = 0; i < arrSize; i++) {
                int next = Integer.parseInt(st.nextToken());

                for (int j = 0; j < next - prev; j++) {
                    sb.append(i + 1).append(" ");
                }
                prev = next;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
