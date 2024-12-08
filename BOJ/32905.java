import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int taskCnt = Integer.parseInt(st.nextToken());
            int stakeholderCnt = Integer.parseInt(st.nextToken());

            int verifyTask = 0;

            for (int task = 0; task < taskCnt; task++) {
                int accountableCnt = 0;

                StringTokenizer involvements = new StringTokenizer(br.readLine());
                for (int stakeholder = 0; stakeholder < stakeholderCnt; stakeholder++) {
                    String involvement = involvements.nextToken();
                    if ("A".equals(involvement)) {
                        accountableCnt++;
                    }
                }

                if (accountableCnt == 1) {
                    verifyTask++;
                }
            }

            sb.append(verifyTask == taskCnt ? "Yes" : "No");

            bw.write(sb.toString());
        }
    }
}
