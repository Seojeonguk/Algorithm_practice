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

        int standingPersonCnt = Integer.parseInt(br.readLine());
        int[] thinkingTips = new int[standingPersonCnt];
        for (int personNum = 0; personNum < standingPersonCnt; personNum++) {
            thinkingTips[personNum] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(thinkingTips);

        long maxTip = 0;
        int giveTipCnt = 0;
        for (int i = standingPersonCnt - 1; i >= 0; i--) {
            int tip = thinkingTips[i] - giveTipCnt;
            if (tip > 0) {
                maxTip += tip;
                giveTipCnt++;
            }
        }

        sb.append(maxTip);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
