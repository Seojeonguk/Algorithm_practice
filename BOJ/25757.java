import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int requestNum = Integer.parseInt(st.nextToken());
        char gameType = st.nextToken().charAt(0);
        HashSet<String> requestNames = new HashSet<>();
        for (int i = 0; i < requestNum; i++) {
            String name = br.readLine();
            requestNames.add(name);
        }

        int gameParticipantNum = 2;
        if (gameType == 'F') {
            gameParticipantNum = 3;
        } else if (gameType == 'O') {
            gameParticipantNum = 4;
        }

        sb.append(requestNames.size() / (gameParticipantNum - 1));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
