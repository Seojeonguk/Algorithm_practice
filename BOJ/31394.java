import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static final String NONE_SCHOLARSHIP = "None";
    static final String COMMON_SCHOLARSHIP = "Common";
    static final String HIGH_SCHOLARSHIP = "High";
    static final String PERSONAL_SCHOLARSHIP = "Named";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalExam = Integer.parseInt(br.readLine());
        int[] examMarks = new int[totalExam];
        for (int i = 0; i < totalExam; i++) {
            examMarks[i] = Integer.parseInt(br.readLine());
        }

        sb.append(calScholarship(examMarks));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String calScholarship(int[] examMarks) {
        boolean existSatisfactoryMark = Arrays.stream(examMarks).anyMatch(e -> e == 3);
        if (existSatisfactoryMark) {
            return NONE_SCHOLARSHIP;
        }

        boolean existOnlyExcellentMark = Arrays.stream(examMarks).allMatch(e -> e == 5);
        if (existOnlyExcellentMark) {
            return PERSONAL_SCHOLARSHIP;
        }

        Double averageMark = Arrays.stream(examMarks).average().getAsDouble();
        if (Double.compare(averageMark, 4.5d) >= 0) {
            return HIGH_SCHOLARSHIP;
        }

        return COMMON_SCHOLARSHIP;
    }
}
