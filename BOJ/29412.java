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
        int[] turnOnTimes = new int[5];
        for (int i = 0; i < 5; i++) {
            turnOnTimes[i] = Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine());

        int red = 0;
        int yellow = 0;
        int green = 0;

        int idx = 0;
        while (t > 0) {
            int time = Math.min(turnOnTimes[idx], t);
            if (idx == 0) {
                green += time;
            } else if (idx == 1) {
                green += time / 2;
            } else if (idx == 2) {
                yellow += time;
            } else if (idx == 3) {
                red += time;
            } else if (idx == 4) {
                yellow += time;
                red += time;
            }

            t -= time;
            idx = (idx + 1) % turnOnTimes.length;
        }

        sb.append(red).append(" ").append(yellow).append(" ").append(green);

        bw.write(sb.toString());
        bw.flush();
    }
}
