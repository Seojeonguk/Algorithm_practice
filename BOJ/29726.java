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
        int m = Integer.parseInt(st.nextToken());
        int[] happiness = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            happiness[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = n - m - 1;
        int maxHappiness = happiness[right] - happiness[left];
        int min = happiness[left];

        while (right < n) {
            min = Math.min(min, happiness[left]);
            maxHappiness = Math.max(maxHappiness, happiness[right] - min);
            left++;
            right++;
        }

        sb.append(maxHappiness);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
