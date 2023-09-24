import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int VIEW_OF_HUMANITIES_BUILDING = 508;
    final static int INTERNATIONAL_BUILDING = 108;
    final static int FIRST_ENGINEERING_BUILDING = 212;
    final static int ITBT_BUILDING = 305;
    final static int HANYANG_UNIVERSITY_ZIPCODE = 4763;
    final static int MAX_SUBJECT_SCORE = 200;

    public static void main(String[] args) throws Exception {
        int studentNum = Integer.parseInt(br.readLine());

        ArrayList<int[]> cases = new ArrayList<>();
        for (int koreanEnglishDiff = 0; koreanEnglishDiff <= MAX_SUBJECT_SCORE; koreanEnglishDiff++) {
            for (int mathResearchDiff = 0; mathResearchDiff <= MAX_SUBJECT_SCORE; mathResearchDiff++) {
                int[] firstDiff = {koreanEnglishDiff * VIEW_OF_HUMANITIES_BUILDING, koreanEnglishDiff * INTERNATIONAL_BUILDING};
                int[] secondDiff = {mathResearchDiff * FIRST_ENGINEERING_BUILDING, mathResearchDiff * ITBT_BUILDING};

                boolean canMakeStudentNum = false;
                Loop1:
                for (int i = 0; i < firstDiff.length; i++) {
                    for (int j = 0; j < secondDiff.length; j++) {
                        if ((firstDiff[i] + secondDiff[j]) * HANYANG_UNIVERSITY_ZIPCODE == studentNum) {
                            canMakeStudentNum = true;
                            break Loop1;
                        }
                    }
                }
                if (canMakeStudentNum) {
                    cases.add(new int[]{koreanEnglishDiff, mathResearchDiff});
                }
            }
        }
        sb.append(cases.size()).append("\n");
        if (!cases.isEmpty()) {
            for (int i = 0; i < cases.size(); i++) {
                sb.append(String.format("%d %d\n", cases.get(i)[0], cases.get(i)[1]));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
