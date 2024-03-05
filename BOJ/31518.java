import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int WHEEL_COUNT = 3;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int wheelSize = Integer.parseInt(br.readLine());

        int sevenIncludeWheelCnt = 0;
        for (int wheelNum = 1; wheelNum <= WHEEL_COUNT; wheelNum++) {
            StringTokenizer wheelHasNums = new StringTokenizer(br.readLine());
            for (int i = 0; i < wheelSize; i++) {
                int num = Integer.parseInt(wheelHasNums.nextToken());
                if (num == 7) {
                    sevenIncludeWheelCnt++;
                }
            }
        }

        sb.append(sevenIncludeWheelCnt == 3 ? 777 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
