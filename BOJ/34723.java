import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pizza = Integer.parseInt(st.nextToken());
        int noodle = Integer.parseInt(st.nextToken());
        int chicken = Integer.parseInt(st.nextToken());

        int target = Integer.parseInt(br.readLine());

        int minDiff = Integer.MAX_VALUE;
        for (int pizzaCnt = 1; pizzaCnt <= pizza; pizzaCnt++) {
            for (int noodleCnt = 1; noodleCnt <= noodle; noodleCnt++) {
                for (int chickenCnt = 1; chickenCnt <= chicken; chickenCnt++) {
                    int sum = (pizzaCnt + noodleCnt) * (noodleCnt + chickenCnt);
                    int diff = Math.abs(target - sum);

                    minDiff = Math.min(minDiff, diff);
                }
            }
        }

        sb.append(minDiff);

        bw.write(sb.toString());
        bw.flush();
    }
}
