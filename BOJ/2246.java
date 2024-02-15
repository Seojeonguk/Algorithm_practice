import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int condoCnt = Integer.parseInt(br.readLine());
        int[][] condos = new int[condoCnt][2];
        for (int i = 0; i < condoCnt; i++) {
            StringTokenizer condoInfo = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                condos[i][j] = Integer.parseInt(condoInfo.nextToken());
            }
        }

        int candidateCnt = 0;
        for (int i = 0; i < condoCnt; i++) {
            if (isCandidate(condos, i)) {
                candidateCnt++;
            }
        }

        sb.append(candidateCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isCandidate(int[][] condos, int candidateCondoNum) {
        for (int i = 0; i < condos.length; i++) {
            if (i == candidateCondoNum) {
                continue;
            }

            if (condos[candidateCondoNum][0] >= condos[i][0]) {
                if (condos[candidateCondoNum][1] >= condos[i][1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
