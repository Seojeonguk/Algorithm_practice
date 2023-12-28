import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalProblemCandidate = Integer.parseInt(st.nextToken());
        int totalProblemMember = Integer.parseInt(st.nextToken());

        int totalAskedProblem = 0;
        for (int i = 0; i < totalProblemCandidate; i++) {
            char[] problems = br.readLine().toCharArray();
            int agreeMemberCount = 0;
            for (int j = 0; j < totalProblemMember; j++) {
                if (problems[j] == 'O') {
                    agreeMemberCount++;
                }
            }
            if (agreeMemberCount > totalProblemMember / 2) {
                totalAskedProblem++;
            }
        }

        sb.append(totalAskedProblem);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
