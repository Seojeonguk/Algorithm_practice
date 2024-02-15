import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer sequenceInfo = new StringTokenizer(br.readLine());
            int sequenceLength = Integer.parseInt(sequenceInfo.nextToken());
            int[] sequences = new int[sequenceLength];
            for (int i = 0; i < sequenceLength; i++) {
                sequences[i] = Integer.parseInt(sequenceInfo.nextToken());
            }

            sb.append(isFibbonacciSequence(sequences) ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isFibbonacciSequence(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2] + arr[i - 1] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
