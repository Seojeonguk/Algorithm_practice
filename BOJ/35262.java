import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());
        int notVisitedDays = Integer.parseInt(st.nextToken());

        char[] visitedRecordings = br.readLine().toCharArray();
        int missedVisitStreak = 0;

        boolean canHaveHamburger = true;
        for (int idx = 0; idx < days; idx++) {
            if (visitedRecordings[idx] == '0') {
                missedVisitStreak += 1;
                if (missedVisitStreak >= notVisitedDays) {
                    canHaveHamburger = false;
                    break;
                }
            } else {
                missedVisitStreak = 0;
            }
        }

        sb.append(canHaveHamburger ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
    }
}
