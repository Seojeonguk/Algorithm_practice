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
        int totalSoldier = Integer.parseInt(br.readLine());
        int minPerfectReadySoldier = (totalSoldier + 1) / 2;
        int currentPerfectReadySoldier = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalSoldier; i++) {
            int soldier = Integer.parseInt(st.nextToken());
            if (soldier == 1) {
                currentPerfectReadySoldier++;
            }
        }

        sb.append(Math.max(0, minPerfectReadySoldier - currentPerfectReadySoldier));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
