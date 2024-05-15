import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String retakeCourseCode = br.readLine();

            int courseCnt = Integer.parseInt(br.readLine());

            int admittedRetakeCourseCnt = 0;
            for (int i = 0; i < courseCnt; i++) {
                String courseCode = br.readLine();
                if (retakeCourseCode.substring(0, 5).equals(courseCode.substring(0, 5))) {
                    admittedRetakeCourseCnt++;
                }
            }

            sb.append(admittedRetakeCourseCnt);

            bw.write(sb.toString());
        }
    }
}
