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
        int cupCnt = Integer.parseInt(br.readLine());
        int currentWinnerCup = Integer.parseInt(br.readLine());

        int changedCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < changedCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int targetA = Integer.parseInt(st.nextToken());
            int targetB = Integer.parseInt(st.nextToken());

            if (targetA == currentWinnerCup) {
                currentWinnerCup = targetB;
            } else if (targetB == currentWinnerCup) {
                currentWinnerCup = targetA;
            }
        }

        sb.append(currentWinnerCup);

        bw.write(sb.toString());
        bw.flush();
    }
}
