import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tired = Integer.parseInt(st.nextToken());
        int task = Integer.parseInt(st.nextToken());
        int rescueTired = Integer.parseInt(st.nextToken());
        int maxTired = Integer.parseInt(st.nextToken());

        int currentTired = 0;
        int solvedTask = 0;
        for (int time = 0; time < 24; time++) {
            if (currentTired + tired <= maxTired) {
                currentTired += tired;
                solvedTask += task;
            } else {
                currentTired -= rescueTired;
                if (currentTired < 0) {
                    currentTired = 0;
                }
            }
        }
        sb.append(solvedTask);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
