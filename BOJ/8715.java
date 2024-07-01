import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            HashSet<Integer> appearedValues = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (0 < a && a < n + 1) {
                    appearedValues.add(a);
                }
            }

            sb.append(appearedValues.size() == n ? "TAK" : "NIE");

            bw.write(sb.toString());
        }
    }
}
