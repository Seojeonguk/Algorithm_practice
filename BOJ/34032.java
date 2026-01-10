import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int teamCnt = Integer.parseInt(br.readLine());
        char[] commands = br.readLine().toCharArray();
        int surrenderCnt = 0;
        for (int i = 0; i < teamCnt; i++) {
            if (commands[i] == 'O') {
                surrenderCnt++;
            }
        }

        sb.append((teamCnt + 1) / 2 <= surrenderCnt ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
    }
}
