import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int eventCnt = Integer.parseInt(br.readLine());
            int usableProblem = 0;
            for (int event = 0; event < eventCnt; event++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int query = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                if (query == 1) {
                    usableProblem += value;
                } else if (query == 2) {
                    usableProblem -= value;
                    if (usableProblem < 0) {
                        sb.append("Adios");
                        break;
                    }
                }
            }

            if (sb.isEmpty()) {
                sb.append("See you next month");
            }

            bw.write(sb.toString());
        }
    }
}
