import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int aScore = Integer.parseInt(st.nextToken());
        int bScore = Integer.parseInt(st.nextToken());

        int cScore = 0;
        for (int i = 0; i < 10; i++) {
            int score = (1 << i);
            boolean aSuccess = (aScore & score) > 0;
            boolean bSuccess = (bScore & score) > 0;
            if ((aSuccess && !bSuccess) || (!aSuccess && bSuccess)) {
                cScore += score;
            }
        }
        sb.append(cScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
