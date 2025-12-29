import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int REQUIRED_SUBJECT_CNT = 6;

    private static final String SUCCESS_GRADUATION = "Success!";
    private static final String FAIL_GRADUATION = "Oh My God!";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int lastSubjectCnt = Integer.parseInt(br.readLine());


            bw.write(REQUIRED_SUBJECT_CNT <= lastSubjectCnt ? SUCCESS_GRADUATION : FAIL_GRADUATION);
            bw.flush();
        }
    }
}
