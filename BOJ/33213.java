import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int childCnt = Integer.parseInt(br.readLine());
            Set<Integer> nicknames = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int oddTeamCnt = 0;
            int evenTeamCnt = 0;
            for (int i = 0; i < childCnt; i++) {
                int nickname = Integer.parseInt(st.nextToken());
                if (nickname % 2 == 0) {
                    evenTeamCnt++;
                } else {
                    oddTeamCnt++;
                }

                nicknames.add(nickname);
            }

            int startNickname = (oddTeamCnt > evenTeamCnt ? 1 : 2);
            for (int currentNickname = startNickname; ; currentNickname += 2) {
                if (!nicknames.contains(currentNickname)) {
                    sb.append(currentNickname);
                    break;
                }
            }

            bw.write(sb.toString());
        }
    }
}
