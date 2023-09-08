import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine());
        int[] collections = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < size; idx++) {
            collections[idx] = Integer.parseInt(st.nextToken());
        }
        int includingValue = Integer.parseInt(br.readLine());

        Arrays.sort(collections);
        int maxMinValue = 0, minMaxValue = 0;
        for (int idx = 0; idx < size; idx++) {
            if (collections[idx] <= includingValue) {
                maxMinValue = collections[idx];
            }
            if (minMaxValue == 0 && includingValue <= collections[idx]) {
                minMaxValue = collections[idx];
            }
        }

        int totalRange = getCombination((minMaxValue - 1) - (maxMinValue + 1));
        int leftNotIncludingRange = getCombination((includingValue - 1) - (maxMinValue + 1));
        int rightNotIncludingRange = getCombination((minMaxValue - 1) - (includingValue + 1));

        sb.append(totalRange - (leftNotIncludingRange + rightNotIncludingRange));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCombination(int n) {
        if (n < 1) {
            return 0;
        }
        int combination = n * (n + 1) / 2;
        return combination;
    }
}
