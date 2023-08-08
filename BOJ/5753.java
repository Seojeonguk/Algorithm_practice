import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int alumniCnt, dinnerCnt;
    static int[] attendaceCnt;

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            alumniCnt = Integer.parseInt(st.nextToken());
            dinnerCnt = Integer.parseInt(st.nextToken());
            if (alumniCnt == 0 && dinnerCnt == 0) {
                break;
            }

            boolean isExistAllDinnerAttendance = false;
            attendaceCnt = new int[alumniCnt];

            for (int i = 0; i < dinnerCnt; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < alumniCnt; j++) {
                    attendaceCnt[j] += Integer.parseInt(st.nextToken());
                    if (attendaceCnt[j] == dinnerCnt) {
                        isExistAllDinnerAttendance = true;
                    }
                }
            }

            sb.append((isExistAllDinnerAttendance ? "yes" : "no")).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
