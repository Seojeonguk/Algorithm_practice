import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_STUDY_TIME = 10000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer friendInfo = new StringTokenizer(br.readLine());
        int maxStudyTime = Integer.parseInt(friendInfo.nextToken());
        int subjectCnt = Integer.parseInt(friendInfo.nextToken());

        int[] dp = new int[MAX_STUDY_TIME + 1];

        for (int subjectNum = 0; subjectNum < subjectCnt; subjectNum++) {
            StringTokenizer subjectInfo = new StringTokenizer(br.readLine());
            int importance = Integer.parseInt(subjectInfo.nextToken());
            int requiredStudyTime = Integer.parseInt(subjectInfo.nextToken());

            for (int j = maxStudyTime; j >= requiredStudyTime; j--) {
                if (dp[j] < importance + dp[j - requiredStudyTime]) {
                    dp[j] = importance + dp[j - requiredStudyTime];
                }
            }
        }

        sb.append(dp[maxStudyTime]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
