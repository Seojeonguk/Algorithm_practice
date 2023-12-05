import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int[] ranks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int competitionRate = 0;
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[0] - ranks[i] <= 1000) {
                competitionRate++;
            }
        }

        sb.append(competitionRate);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
