import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int stopCnt = Integer.parseInt(br.readLine());
        long minimumEnergy = 0;

        int[] stops = new int[stopCnt];
        for (int idx = 0; idx < stopCnt; idx++) {
            stops[idx] = Integer.parseInt(br.readLine());
            if (idx > 0) {
                int prevStopsDiff = stops[idx] - stops[idx - 1];
                minimumEnergy += (long) prevStopsDiff * prevStopsDiff;
            }
        }
        sb.append(minimumEnergy);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
