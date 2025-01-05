import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int CHOSEN_CNT = 5;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[][] kernels = new int[CHOSEN_CNT][2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int totalEars = 0;

            for (int i = 0; i < CHOSEN_CNT; i++) {
                kernels[i][0] = Integer.parseInt(st.nextToken());
                kernels[i][1] = Integer.parseInt(st.nextToken());

                totalEars += kernels[i][0] * kernels[i][1];
            }

            StringTokenizer constants = new StringTokenizer(br.readLine());
            int corn = Integer.parseInt(constants.nextToken());
            int KWF = Integer.parseInt(constants.nextToken());

            int avgEars = totalEars / 5;

            sb.append(avgEars * corn / KWF);

            bw.write(sb.toString());
        }
    }
}
