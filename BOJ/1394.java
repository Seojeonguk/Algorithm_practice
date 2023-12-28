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

    static final int MOD = 900528;

    public static void main(String[] args) throws Exception {
        String canPasswordWords = br.readLine();
        char[] computerPassword = br.readLine().toCharArray();

        int attemptCnt = 0;
        for (int i = 0; i < computerPassword.length; i++) {
            char c = computerPassword[i];
            int firstAppearedIdx = canPasswordWords.indexOf(c);
            attemptCnt = (attemptCnt * canPasswordWords.length()) % MOD;
            attemptCnt = (attemptCnt + firstAppearedIdx + 1) % MOD;
        }

        sb.append(attemptCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
