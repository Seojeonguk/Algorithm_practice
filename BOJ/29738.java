import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int WORLD_FINAL = 25;
    final static int ROUND3 = 1000;
    final static int ROUND2 = 4500;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int lastProblemRound = Integer.parseInt(br.readLine());
            String round = "";
            if (lastProblemRound <= WORLD_FINAL) {
                round = "World Finals";
            } else if (lastProblemRound <= ROUND3) {
                round = "Round 3";
            } else if (lastProblemRound <= ROUND2) {
                round = "Round 2";
            } else {
                round = "Round 1";
            }
            sb.append(String.format("Case #%d: %s", tc, round)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
