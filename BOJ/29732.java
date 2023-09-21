import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(st.nextToken());
        int medicineCnt = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        String initPeople = br.readLine();

        boolean[] isInfect = new boolean[peopleCnt + 1];
        for (int idx = 0; idx < initPeople.length(); idx++) {
            char c = initPeople.charAt(idx);
            if (c == '.') {
                continue;
            }
            int min = Math.max(1, idx + 1 - distance);
            int max = Math.min(peopleCnt, idx + 1 + distance);
            for (int i = min; i <= max; i++) {
                isInfect[i] = true;
            }
        }


        int infectionCnt = 0;
        for (int i = 1; i <= peopleCnt; i++) {
            if (isInfect[i]) {
                infectionCnt++;
            }
        }
        sb.append(medicineCnt >= infectionCnt ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
