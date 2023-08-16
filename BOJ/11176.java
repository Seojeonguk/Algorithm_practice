import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            int attempts = Integer.parseInt(st.nextToken());
            int candidateBottleCnt = Integer.parseInt(st.nextToken());

            int emptyShampooBottleCnt = 0;
            for (int candidateBottle = 0; candidateBottle < candidateBottleCnt; candidateBottle++) {
                int attemptForEmpty = Integer.parseInt(br.readLine());
                if (attempts < attemptForEmpty) {
                    emptyShampooBottleCnt++;
                }
            }
            sb.append(emptyShampooBottleCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
