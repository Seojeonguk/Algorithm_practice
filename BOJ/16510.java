import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int jobCnt = Integer.parseInt(st.nextToken());
        int questionCnt = Integer.parseInt(st.nextToken());

        int[] jobTimes = new int[jobCnt];
        int[] prefixSum = new int[jobCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < jobCnt; idx++) {
            jobTimes[idx] = Integer.parseInt(st.nextToken());
            prefixSum[idx] = (idx > 0 ? prefixSum[idx - 1] : 0) + jobTimes[idx];
        }

        for (int i = 0; i < questionCnt; i++) {
            int timeToProcess = Integer.parseInt(br.readLine());

            int idx = Arrays.binarySearch(prefixSum, timeToProcess);
            sb.append(Math.abs(idx + 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
