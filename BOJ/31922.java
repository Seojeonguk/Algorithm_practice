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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int division1Prize = Integer.parseInt(st.nextToken());
            int division2Prize = Integer.parseInt(st.nextToken());
            int shakePrize = Integer.parseInt(st.nextToken());

            int maxPrize = getMaxPrize(division1Prize, division2Prize, shakePrize);
            sb.append(maxPrize);

            bw.write(sb.toString());
        }
    }

    public static int getMaxPrize(int division1Prize, int division2Prize, int shakePrize) {
        return Math.max(division1Prize + shakePrize, division2Prize);
    }
}
