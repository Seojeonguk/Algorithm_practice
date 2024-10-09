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

            int mosquitoCnt = Integer.parseInt(br.readLine());
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;

            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;

            for (int i = 0; i < mosquitoCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());


                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);

                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            int maxDiff = Math.max(maxX - minX, maxY - minY);
            sb.append(maxDiff * maxDiff);

            bw.write(sb.toString());
        }
    }
}
