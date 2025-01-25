import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int gameCnt = Integer.parseInt(br.readLine());

            char[] playerA = br.readLine().toCharArray();
            char[] playerB = br.readLine().toCharArray();

            int winA = 0;
            int winB = 0;

            for (int game = 0; game < gameCnt; game++) {
                if (playerA[game] == 'R') {
                    if (playerB[game] == 'P') {
                        winB++;
                    } else if (playerB[game] == 'S') {
                        winA++;
                    }
                } else if (playerA[game] == 'P') {
                    if (playerB[game] == 'R') {
                        winA++;
                    } else if (playerB[game] == 'S') {
                        winB++;
                    }
                } else {
                    if (playerB[game] == 'R') {
                        winB++;
                    } else if (playerB[game] == 'P') {
                        winA++;
                    }
                }
            }

            sb.append(winA).append(" ").append(winB);

            bw.write(sb.toString());
        }
    }
}
