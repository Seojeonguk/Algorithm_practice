import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_SUBJECT_CNT = 5;
    final static int VIEW_OF_HUMANITIES_BUILDING = 508;
    final static int INTERNATIONAL_BUILDING = 108;
    final static int FIRST_ENGINEERING_BUILDING = 212;
    final static int ITBT_BUILDING = 305;
    final static int HAENGWON_PARK_BUILDING = 707;
    final static int HANYANG_UNIVERSITY_ZIPCODE = 4763;

    public static void main(String[] args) throws Exception {
        int subjectCnt = Integer.parseInt(br.readLine());
        int[] scores = new int[MAX_SUBJECT_CNT];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < subjectCnt; idx++) {
            scores[idx] = Integer.parseInt(st.nextToken());
        }

        int firstCondition = Math.abs(scores[0] - scores[2]) * (scores[0] > scores[2] ? VIEW_OF_HUMANITIES_BUILDING : INTERNATIONAL_BUILDING);
        int secondCondition = Math.abs(scores[1] - scores[3]) * (scores[1] > scores[3] ? FIRST_ENGINEERING_BUILDING : ITBT_BUILDING);

        int thirdCondition = 0;
        if (subjectCnt == 5) {
            thirdCondition = scores[4] * HAENGWON_PARK_BUILDING;
        }

        int studentId = (firstCondition + secondCondition + thirdCondition) * HANYANG_UNIVERSITY_ZIPCODE;
        sb.append(studentId);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
