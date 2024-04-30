import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int[] colors = new int[n + 1];
            colors[1] = 1;
            int colorCnt = 1;
            for (int i = 2; i <= n; i++) {
                if (colors[i] > 0) {
                    continue;
                }

                colorCnt++;
                for (int j = i; j <= n; j += i) {
                    colors[j] = colorCnt;
                }
            }

            sb.append(colorCnt).append("\n");
            for (int i = 1; i <= n; i++) {
                sb.append(colors[i]).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
