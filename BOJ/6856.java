import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int nDice = Integer.parseInt(br.readLine());
        int mDice = Integer.parseInt(br.readLine());

        int wayCnt = 0;
        for (int i = 1; i <= Math.min(nDice, 9); i++) {
            for (int j = 1; j <= Math.min(mDice, 9); j++) {
                if (i + j == 10) {
                    wayCnt++;
                }
            }
        }
        sb.append("There ").append(wayCnt == 1 ? "is " : "are ").append(wayCnt).append(wayCnt == 1 ? " way" : " ways").append(" to get the sum 10.");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
