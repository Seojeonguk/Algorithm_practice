import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] distinctionGrades = br.readLine().toCharArray();
            int subjectCnt = 0;
            double sumGrade = 0.0;
            for (int idx = 0; idx < distinctionGrades.length; idx++) {
                if (Character.isAlphabetic(distinctionGrades[idx])) {
                    subjectCnt++;
                }

                if (distinctionGrades[idx] == '+' || distinctionGrades[idx] == 'F') {
                    continue;
                }

                double grade = 4.0 - (distinctionGrades[idx] - 'A');
                if (idx + 1 < distinctionGrades.length && distinctionGrades[idx + 1] == '+') {
                    grade += 0.5;
                }
                sumGrade += grade;
            }

            double gradeAvg = sumGrade / subjectCnt;
            sb.append(gradeAvg);

            bw.write(sb.toString());
        }
    }
}
