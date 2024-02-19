import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MAX_VALUE = 10000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] appearedCnts = new int[MAX_VALUE + 1];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            appearedCnts[value]++;
        }

        int maxAppearedCntIdx = 0;
        for (int i = 1; i <= MAX_VALUE; i++) {
            if (appearedCnts[maxAppearedCntIdx] < appearedCnts[i]) {
                maxAppearedCntIdx = i;
            }
        }

        sb.append(maxAppearedCntIdx);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
