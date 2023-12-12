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
        int stateCnt = Integer.parseInt(br.readLine());

        int[] votes = new int[2];
        int[] elections = new int[2];

        for (int i = 0; i < stateCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int election = Integer.parseInt(st.nextToken());
            int firstVotes = Integer.parseInt(st.nextToken());
            int secondVotes = Integer.parseInt(st.nextToken());

            votes[0] += firstVotes;
            votes[1] += secondVotes;

            if (firstVotes > secondVotes) {
                elections[0] += election;
            } else if (firstVotes < secondVotes) {
                elections[1] += election;
            }
        }

        if (votes[0] > votes[1] && elections[0] > elections[1]) {
            sb.append(1);
        } else if (votes[0] < votes[1] && elections[0] < elections[1]) {
            sb.append(2);
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
