import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int add = Integer.parseInt(br.readLine());
        int aLength = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bLength = Integer.parseInt(br.readLine());
        int[] brr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int conditionSatisfiedCnt = 0;
        for (int a : arr) {
            for (int b : brr) {
                if (a + add == b) {
                    conditionSatisfiedCnt++;
                }
            }
        }

        sb.append(conditionSatisfiedCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
