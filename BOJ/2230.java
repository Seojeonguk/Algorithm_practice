import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        int[] sequences = new int[n];
        for (int idx = 0; idx < n; idx++) {
            sequences[idx] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(sequences);

        int minDiff = Integer.MAX_VALUE;

        for (int idx = 0; idx < n; idx++) {
            int bs = Arrays.binarySearch(sequences, sequences[idx] + diff);
            int lower = (bs < 0 ? -(bs + 1) : bs);
            if (lower != n && idx != lower) {
                minDiff = Math.min(minDiff, Math.abs(sequences[idx] - sequences[lower]));
            }
        }
        sb.append(minDiff);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
