import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String word = br.readLine();
        int minTotalTime = 0;
        int currentIdx = 0;
        for (int idx = 0; idx < word.length(); idx++) {
            int nextIdx = word.charAt(idx) - 'A';
            int right = Math.abs(currentIdx - nextIdx);
            int left = Math.abs(26 - right);

            minTotalTime += Math.min(right, left);
            
            currentIdx = nextIdx;
        }

        sb.append(minTotalTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
