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
            int fillingCnt = Integer.parseInt(st.nextToken());
            int pancakeCnt = Integer.parseInt(st.nextToken());

            int[] fillings = new int[fillingCnt];
            StringTokenizer fillingTokenizer = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < fillingCnt; idx++) {
                fillings[idx] = Integer.parseInt(fillingTokenizer.nextToken());
            }

            int[] pancakes = new int[pancakeCnt];
            StringTokenizer pancakeTokenizer = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < pancakeCnt; idx++) {
                pancakes[idx] = Integer.parseInt(pancakeTokenizer.nextToken());
            }

            int sumTasting = 0;
            for (int i = 0; i < fillingCnt; i++) {
                for (int j = 0; j < pancakeCnt; j++) {
                    sumTasting += (fillings[i] + pancakes[j]) * Math.max(fillings[i], pancakes[j]);
                }
            }

            sb.append(sumTasting);

            bw.write(sb.toString());
        }
    }
}
