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
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int participantCnt = Integer.parseInt(st.nextToken());
            int totalTime = Integer.parseInt(st.nextToken());
            int limitTime = Integer.parseInt(st.nextToken());

            int freezeTime = limitTime;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < participantCnt; i++) {
                int time = Integer.parseInt(st.nextToken());
                if (time != -1) {
                    freezeTime = Math.max(freezeTime, totalTime - time);
                }
            }

            sb.append(String.format("The scoreboard has been frozen with %d minute%s remaining.\n", freezeTime, freezeTime == 1 ? "" : "s"));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
