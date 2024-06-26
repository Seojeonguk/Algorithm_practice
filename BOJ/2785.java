import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int chainCnt = Integer.parseInt(br.readLine());
            int[] chainLengths = new int[chainCnt];
            StringTokenizer lengths = new StringTokenizer(br.readLine());
            for (int i = 0; i < chainCnt; i++) {
                chainLengths[i] = Integer.parseInt(lengths.nextToken());
            }

            Arrays.sort(chainLengths);
            int ringCnt = 0;
            int remainedChainCnt = chainCnt;
            for (int i = 0; i < chainCnt; i++) {
                while (ringCnt < remainedChainCnt - 1) {
                    chainLengths[i]--;
                    ringCnt++;
                    if (chainLengths[i] == 0) {
                        remainedChainCnt--;
                        break;
                    }
                }
            }

            sb.append(ringCnt);

            bw.write(sb.toString());
        }
    }
}
