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

        for (int tc = 0; ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long tileWidth = Long.parseLong(st.nextToken());
            long tileHeight = Long.parseLong(st.nextToken());

            if (tileWidth == 0 && tileHeight == 0) {
                break;
            }

            long tileGCD = gcd(tileWidth, tileHeight);
            sb.append((tileWidth / tileGCD) * (tileHeight / tileGCD)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long gcd(long a, long b) {
        return (b == 0 ? a : gcd(b, a % b));
    }
}
