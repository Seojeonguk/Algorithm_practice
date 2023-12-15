import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int game = Integer.parseInt(br.readLine());
        long mariScore = 0, juriScore = 0;
        int mariWin = 0, juriWin = 0;
        for (int i = 0; i < game; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int score = Integer.parseInt(st.nextToken());
            if (c == 'M') {
                mariScore += score;
                mariWin++;
            } else {
                juriScore += score;
                juriWin++;
            }
        }

        double mariAverage = 0, juriAverage = 0;
        if (mariWin > 0) {
            mariAverage = 1.0d * mariScore / mariWin;
        }
        if (juriWin > 0) {
            juriAverage = 1.0d * juriScore / juriWin;
        }

        if (mariAverage > juriAverage) {
            sb.append("M");
        } else if (mariAverage < juriAverage) {
            sb.append("J");
        } else {
            sb.append("V");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
