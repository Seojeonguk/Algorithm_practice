import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int jobCnt = Integer.parseInt(br.readLine());
        int[][] jobs = new int[jobCnt][2];

        for (int i = 0; i < jobCnt; i++) {
            st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jobs, (o1, o2) -> {
            return Integer.compare(o2[1], o1[1]);
        });

        int startTime = 99999999;
        for (int i = 0; i < jobCnt; i++) {
            startTime = Math.min(startTime, jobs[i][1]) - jobs[i][0];
        }

        sb.append(startTime < 0 ? -1 : startTime);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
