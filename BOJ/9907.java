import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] weights = {2, 7, 6, 5, 4, 3, 2};
    static char[] capitalLetter = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'Z'};

    public static void main(String[] args) throws Exception {
        String NICE = br.readLine();

        int weightedSum = 0;
        for (int idx = 0; idx < 7; idx++) {
            weightedSum += (NICE.charAt(idx) - '0') * weights[idx];
        }
        sb.append(capitalLetter[weightedSum % 11]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
