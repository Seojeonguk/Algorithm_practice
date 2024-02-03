import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int[] times = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

            String[] binaryTimes = new String[3];
            for (int i = 0; i < 3; i++) {
                String binaryTime = Integer.toBinaryString(times[i]);
                while (binaryTime.length() < 6) {
                    binaryTime = "0" + binaryTime;
                }
                binaryTimes[i] = binaryTime;
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(binaryTimes[j].charAt(i));
                }
            }
            sb.append(" ");

            for (int i = 0; i < 3; i++) {
                sb.append(binaryTimes[i]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
