import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final long LIMIT = 100000000L;
    private static final String PASSED_RSLT = "Accepted";
    private static final String FAILED_RSLT = "Time limit exceeded";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int recursionCnt = Integer.parseInt(br.readLine());
            long totalRecursionCnt = (long) recursionCnt * recursionCnt;

            bw.write(totalRecursionCnt <= LIMIT ? PASSED_RSLT : FAILED_RSLT);
            bw.flush();
        }
    }
}
