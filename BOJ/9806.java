import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int sonCnt = Integer.parseInt(br.readLine());
        int exponent = Integer.parseInt(br.readLine());

        int[] mentalOfSons = new int[sonCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < sonCnt; idx++) {
            mentalOfSons[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(mentalOfSons);

        int maxSumOfMentals = 0;
        for (int idx = sonCnt - 1; idx >= 0; idx--) {
            int mental = getMental(mentalOfSons[idx], exponent);
            maxSumOfMentals = Math.max(maxSumOfMentals, maxSumOfMentals + mental);
        }
        sb.append(maxSumOfMentals);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMental(int base, int exponent) {
        int mental = 1;
        for (int i = 0; i < exponent; i++) {
            mental *= base;
        }
        return mental;
    }
}
