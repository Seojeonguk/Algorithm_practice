import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int minGn = c * n0;
        int maxGn = c * 1000;

        int minFn = a1 * n0 + a0;
        int maxFn = a1 * 1000 + a0;

        if (minGn <= minFn && maxGn <= maxFn) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
