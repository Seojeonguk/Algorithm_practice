import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int[] firstStandardTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondStandardTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] firstSpecificTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = firstSpecificTimes[0] * firstStandardTimes[1] * firstStandardTimes[2] + firstSpecificTimes[1] * firstStandardTimes[2] + firstSpecificTimes[2];
        sb.append(total / (secondStandardTimes[1] * secondStandardTimes[2])).append(" ")
                .append(total % (secondStandardTimes[1] * secondStandardTimes[2]) / secondStandardTimes[2]).append(" ")
                .append(total % secondStandardTimes[2]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
