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
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int minDistance = Integer.MAX_VALUE;
        int selectRow = -1;
        int selectCol = -1;
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                int seat = Integer.parseInt(st.nextToken());
                if (seat == 1) {
                    continue;
                }

                int distance = i + Math.abs((col + 1) / 2 - j);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectRow = i;
                    selectCol = j;
                }
            }
        }

        if (minDistance == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(selectRow).append(" ").append(selectCol).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
