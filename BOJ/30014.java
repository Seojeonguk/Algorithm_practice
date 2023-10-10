import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int necklessCnt = Integer.parseInt(br.readLine());
        int[] necklessValues = new int[necklessCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < necklessCnt; idx++) {
            necklessValues[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(necklessValues);
        int[] sortedValues = new int[necklessCnt];
        int left = 0, right = necklessCnt - 1;
        int valuesIdx = 0;
        while (left < right) {
            sortedValues[left++] = necklessValues[valuesIdx++];
            sortedValues[right--] = necklessValues[valuesIdx++];
        }
        if (left == right) {
            sortedValues[left] = necklessValues[valuesIdx];
        }

        int sumValue = 0;
        for (int idx = 0; idx < necklessCnt; idx++) {
            sumValue += sortedValues[idx] * sortedValues[(idx + 1) % necklessCnt];
        }
        sb.append(sumValue).append("\n");
        for (int idx = 0; idx < necklessCnt; idx++) {
            sb.append(sortedValues[idx]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
