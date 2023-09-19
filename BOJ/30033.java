import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int studyDay = Integer.parseInt(br.readLine());
        int[] plannedStudy = new int[studyDay];
        int[] studied = new int[studyDay];

        st = new StringTokenizer(br.readLine());
        for (int study = 0; study < studyDay; study++) {
            plannedStudy[study] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int study = 0; study < studyDay; study++) {
            studied[study] = Integer.parseInt(st.nextToken());
        }

        int aLotOfStudyDay = 0;
        for (int study = 0; study < studyDay; study++) {
            aLotOfStudyDay += (plannedStudy[study] <= studied[study] ? 1 : 0);
        }
        sb.append(aLotOfStudyDay);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
