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
            int studentCnt = Integer.parseInt(st.nextToken());
            int cardCnt = Integer.parseInt(st.nextToken());

            int[] numberTags = new int[studentCnt + 1];
            for (int i = 1; i <= studentCnt; i++) {
                numberTags[i] = Integer.parseInt(br.readLine());
            }

            for (int card = 1; card <= cardCnt; card++) {
                for (int i = 1; i < studentCnt; i++) {
                    if (numberTags[i] % card > numberTags[i + 1] % card) {
                        int tmp = numberTags[i];
                        numberTags[i] = numberTags[i + 1];
                        numberTags[i + 1] = tmp;
                    }
                }
            }

            for (int i = 1; i <= studentCnt; i++) {
                sb.append(numberTags[i]).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
