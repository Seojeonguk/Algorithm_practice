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
        st = new StringTokenizer(br.readLine());
        int initialDisposition = Integer.parseInt(st.nextToken());
        int tiringActivityCnt = Integer.parseInt(st.nextToken());
        int invigoratingActivityCnt = Integer.parseInt(st.nextToken());

        int[] tiringActivities = new int[tiringActivityCnt];
        for (int i = 0; i < tiringActivityCnt; i++) {
            tiringActivities[i] = Integer.parseInt(br.readLine());
        }

        int[] invigorationActivities = new int[invigoratingActivityCnt];
        for (int i = 0; i < invigoratingActivityCnt; i++) {
            invigorationActivities[i] = Integer.parseInt(br.readLine());
        }
        int remainedDisposition = initialDisposition + Arrays.stream(invigorationActivities).sum();

        int performActivityCnt = invigoratingActivityCnt;
        for (int i = 0; i < tiringActivityCnt; i++) {
            if (tiringActivities[i] <= remainedDisposition) {
                remainedDisposition -= tiringActivities[i];
                performActivityCnt++;
            } else {
                break;
            }
        }

        sb.append(performActivityCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
