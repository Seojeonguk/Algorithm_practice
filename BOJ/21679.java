import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int keyCnt = Integer.parseInt(br.readLine());
        int[] canPressedCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int clickCnt = Integer.parseInt(br.readLine());
        int[] clickKeys = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int i = 0; i < clickCnt; i++) {
            canPressedCnt[clickKeys[i] - 1]--;
        }

        for (int i = 0; i < keyCnt; i++) {
            sb.append(canPressedCnt[i] < 0 ? "yes" : "no").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
