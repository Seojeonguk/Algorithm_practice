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

    static final int BETTING_COST = 100;

    public static void main(String[] args) throws Exception {
        int boxCnt = Integer.parseInt(br.readLine());
        int sumBox = 0;
        int maxCost = BETTING_COST;
        for (int i = 0; i < boxCnt; i++) {
            int box = Integer.parseInt(br.readLine());
            sumBox += box;
            maxCost = Math.max(maxCost, BETTING_COST + sumBox);
        }

        sb.append(maxCost);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
