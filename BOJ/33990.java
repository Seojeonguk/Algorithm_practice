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
        int studentCnt = Integer.parseInt(br.readLine());
        int nearTargetWeight = -1;

        while (studentCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bench = Integer.parseInt(st.nextToken());
            int squat = Integer.parseInt(st.nextToken());
            int dead = Integer.parseInt(st.nextToken());

            int sum = bench + squat + dead;
            if (sum < 512) {
                continue;
            }

            int diff = Math.abs(512 - sum);
            if (nearTargetWeight == -1) {
                nearTargetWeight = sum;
            } else {
                int prevDiff = Math.abs(512 - nearTargetWeight);
                if (diff < prevDiff) {
                    nearTargetWeight = sum;
                }
            }
        }

        sb.append(nearTargetWeight);

        bw.write(sb.toString());
        bw.flush();
    }
}
