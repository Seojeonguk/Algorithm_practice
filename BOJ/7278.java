import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static final int TOTAL_BLOCK = 3;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int targetHeight = Integer.parseInt(br.readLine());

            StringTokenizer blockHeights = new StringTokenizer(br.readLine());

            int minDiff = Integer.MAX_VALUE;
            int minDiffHeight = -1;
            int minDiffBlock = -1;
            for (int i = 0; i < TOTAL_BLOCK; i++) {
                int block = Integer.parseInt(blockHeights.nextToken());
                int divide = targetHeight / block;

                int height = divide * block;

                if (Math.abs(targetHeight - height) < minDiff) {
                    minDiff = Math.abs(targetHeight - height);
                    minDiffHeight = height;
                    minDiffBlock = block;
                }

                height = (divide + 1) * block;
                if (Math.abs(targetHeight - height) < minDiff) {
                    minDiff = Math.abs(targetHeight - height);
                    minDiffHeight = height;
                    minDiffBlock = block;
                }
            }

            sb.append(minDiffBlock).append(" ").append(minDiffHeight);

            bw.write(sb.toString());
        }
    }
}
