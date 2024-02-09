import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int peopleCnt = Integer.parseInt(br.readLine());
        int[] opinions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] underLiars = new int[peopleCnt + 1];
        int[] overLiars = new int[peopleCnt + 1];
        for (int i = 0; i < peopleCnt; i++) {
            if (opinions[i] > 0) {
                overLiars[opinions[i]]++;
            } else {
                underLiars[-opinions[i]]++;
            }
        }

        for (int i = 1; i <= peopleCnt; i++) {
            overLiars[i] += overLiars[i - 1];
            underLiars[i] += underLiars[i - 1];
        }

        ArrayList<Integer> possibleLiars = new ArrayList<>();
        for (int i = 0; i <= peopleCnt; i++) {
            int overLiar = overLiars[peopleCnt] - overLiars[i];
            int underLiar = (i == 0 ? 0 : underLiars[i - 1]);

            if (overLiar + underLiar == i) {
                possibleLiars.add(i);
            }
        }

        sb.append(possibleLiars.size()).append("\n");
        for (int possibleLiar : possibleLiars) {
            sb.append(possibleLiar).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
