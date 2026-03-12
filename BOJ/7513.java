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
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            sb.append("Scenario #").append(testCase).append(":\n");

            int wordCnt = Integer.parseInt(br.readLine());
            String[] words = new String[wordCnt];
            for (int idx = 0; idx < wordCnt; idx++) {
                words[idx] = br.readLine();
            }

            int participantCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < participantCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int passwordWordCnt = Integer.parseInt(st.nextToken());

                for (int j = 0; j < passwordWordCnt; j++) {
                    int idx = Integer.parseInt(st.nextToken());
                    sb.append(words[idx]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
