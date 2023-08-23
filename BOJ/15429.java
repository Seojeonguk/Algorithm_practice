import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int gnomeGroupCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < gnomeGroupCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gnomeCnt = Integer.parseInt(st.nextToken());

            int kingsPosition = 0;
            int[] gnomes = new int[gnomeCnt];
            for (int idx = 0; idx < gnomeCnt; idx++) {
                gnomes[idx] = Integer.parseInt(st.nextToken());
                if (gnomes[idx] != gnomes[0] + idx) {
                    kingsPosition = idx + 1;
                    break;
                }
            }
            sb.append(kingsPosition).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
