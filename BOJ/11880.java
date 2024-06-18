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

            int testCase = Integer.parseInt(br.readLine());

            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int width = Integer.parseInt(st.nextToken());
                int depth = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());

                long a = pow(width + depth) + pow(height);
                long b = pow(width + height) + pow(depth);
                long c = pow(depth + height) + pow(width);

                sb.append(Math.min(a, Math.min(b, c))).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static long pow(int a) {
        return (long) a * a;
    }
}
