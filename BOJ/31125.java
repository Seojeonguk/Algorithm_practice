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
        int strikeCnt = Integer.parseInt(br.readLine());
        for (int strike = 0; strike < strikeCnt; strike++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int diceNum = Integer.parseInt(st.nextToken());
            int diceFace = Integer.parseInt(st.nextToken());
            int addValue = Integer.parseInt(st.nextToken());

            int min = diceNum + addValue;
            int max = diceNum * diceFace + addValue;

            sb.append(min <= target && target <= max ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
