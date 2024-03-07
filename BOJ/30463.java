import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int MAX_BIT = (1 << 10);

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer kStringInfo = new StringTokenizer(br.readLine());
        int strCnt = Integer.parseInt(kStringInfo.nextToken());
        int numberCnt = Integer.parseInt(kStringInfo.nextToken());

        int[] appearedCnt = new int[MAX_BIT + 1];
        for (int strNum = 0; strNum < strCnt; strNum++) {
            char[] str = br.readLine().toCharArray();

            int bit = 0;
            for (int strIdx = 0; strIdx < str.length; strIdx++) {
                bit |= (1 << (str[strIdx] - '0'));
            }

            appearedCnt[bit]++;
        }

        long total = 0;
        for (int i = 1; i <= MAX_BIT; i++) {
            for (int j = i; j <= MAX_BIT; j++) {
                int bit = (i | j);
                int bitCnt = Integer.bitCount(bit);

                if (bitCnt == numberCnt) {
                    if (i == j) {
                        total += ((long) appearedCnt[i] * (appearedCnt[i] - 1)) / 2;
                    } else {
                        total += (long) appearedCnt[i] * appearedCnt[j];
                    }
                }
            }
        }
        sb.append(total);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
