import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MIN = 201;
    static final int MAX = 243;

    static final String FAST_INNER = "Inner circle line";
    static final String FAST_OUTER = "Outer circle line";
    static final String SAME = "Same";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int query = Integer.parseInt(br.readLine());

            for (int q = 0; q < query; q++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());

                int inner = (start <= destination ? destination - start : (MAX - start) + (destination - MIN) + 1);
                int outer = (start >= destination ? start - destination : (start - MIN) + (MAX - destination) + 1);

                if (inner > outer) {
                    sb.append(FAST_OUTER).append("\n");
                } else if (inner < outer) {
                    sb.append(FAST_INNER).append("\n");
                } else {
                    sb.append(SAME).append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
