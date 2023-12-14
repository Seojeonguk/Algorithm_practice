import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] firstDices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondDices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstWin = 0, secondWin = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (firstDices[i] > secondDices[j]) {
                    firstWin++;
                } else if (firstDices[i] < secondDices[j]) {
                    secondWin++;
                }
            }
        }

        if (firstWin > secondWin) {
            sb.append("first");
        } else if (firstWin < secondWin) {
            sb.append("second");
        } else {
            sb.append("tie");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
