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
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            sb.append(calMinRequiredBox(red, green, blue));

            bw.write(sb.toString());
        }
    }

    public static int calMinRequiredBox(int red, int green, int blue) {
        int minRequiredBox = 0;

        int minCommonColor = Math.min(red, Math.min(green, blue));
        minRequiredBox += minCommonColor;

        red -= minCommonColor;
        green -= minCommonColor;
        blue -= minCommonColor;

        if (red == 0) {
            minRequiredBox += added(green, blue);
        } else if (green == 0) {
            minRequiredBox += added(red, blue);
        } else {
            minRequiredBox += added(red, green);
        }

        return minRequiredBox;
    }

    public static int added(int a, int b) {
        int ret = a / 3 + b / 3;
        if (a % 3 == 1 && b % 3 == 1) {
            ret++;
        } else {
            ret += (a % 3 + 2) / 3 + (b % 3 + 2) / 3;
        }

        return ret;
    }
}
