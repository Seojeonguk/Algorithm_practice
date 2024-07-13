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

            int marbleCnt = Integer.parseInt(br.readLine());
            int[] marbleNums = new int[marbleCnt];

            StringTokenizer marbles = new StringTokenizer(br.readLine());
            for (int i = 0; i < marbleCnt; i++) {
                marbleNums[i] = Integer.parseInt(marbles.nextToken());
            }

            Arrays.sort(marbleNums);
            int minStringLength = 0;
            for (int i = 0; i < marbleCnt; i++) {
                minStringLength += (Math.abs(marbleNums[i] - marbleNums[(i + 1) % marbleCnt]));
            }

            sb.append(minStringLength);

            bw.write(sb.toString());
        }
    }
}
