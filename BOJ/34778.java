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
        boolean[] isExist = new boolean[5];
        for (int i = 0; i < 10; i++) {
            int rank = Integer.parseInt(st.nextToken());
            isExist[rank] = true;
        }

        int notExistRankCnt = 0;
        for (int i = 1; i <= 4; i++) {
            if (!isExist[i]) {
                notExistRankCnt += 1;
            }
        }

        sb.append(notExistRankCnt);

        bw.write(sb.toString());
        bw.flush();
    }
}
