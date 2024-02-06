import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int classicBabyBlockCnt = Integer.parseInt(br.readLine());

            int requiredMinPaperArea = Integer.MAX_VALUE;
            for (int width = 1; width <= classicBabyBlockCnt; width++) {
                for (int length = 1; length <= classicBabyBlockCnt; length++) {
                    for (int height = 1; height <= classicBabyBlockCnt; height++) {
                        int requiredBlockCnt = width * length * height;
                        if (requiredBlockCnt > classicBabyBlockCnt) {
                            break;
                        }
                        if (requiredBlockCnt == classicBabyBlockCnt) {
                            requiredMinPaperArea = Math.min(requiredMinPaperArea, 2 * (width * length + length * height + width * height));
                        }
                    }
                }
            }

            sb.append(requiredMinPaperArea).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
