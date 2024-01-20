import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            long[] cakes = new long[3];
            long sum = 0;
            for (int i = 0; i < 3; i++) {
                cakes[i] = Long.parseLong(st.nextToken());
                sum += cakes[i];
            }
            long eatCnt = Long.parseLong(st.nextToken());
            sum -= eatCnt;
            Arrays.sort(cakes);

            long maxVolume = 1;
            for (int i = 0; i < 3; i++) {
                long remain = (sum + (2 - i)) / (3 - i);
                cakes[i] = Math.min(cakes[i], remain);
                sum -= cakes[i];
                maxVolume *= cakes[i];
            }

            sb.append(maxVolume).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
