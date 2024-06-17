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
            int waterMelonStage = Integer.parseInt(st.nextToken());
            int currentStageFruitCnt = Integer.parseInt(st.nextToken());

            for (int stage = 2; stage <= waterMelonStage; stage++) {
                currentStageFruitCnt /= 2;
            }

            sb.append(currentStageFruitCnt);

            bw.write(sb.toString());
        }
    }
}
