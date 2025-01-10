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
            char[] myChoices = br.readLine().toCharArray();
            char[] friendChoices = br.readLine().toCharArray();

            int score = 0;
            for (int idx = 0; idx < gameCnt; idx++) {
                score += getScore(myChoices[idx], friendChoices[idx]);
            }

            sb.append(score > 0 ? "victory" : "defeat");

            bw.write(sb.toString());
        }
    }

    public static int getScore(char c, char comp) {
        if (c == 'R') {
            if (comp == 'P') {
                return -1;
            } else if (comp == 'S') {
                return 1;
            }
        } else if (c == 'P') {
            if (comp == 'R') {
                return 1;
            } else if (comp == 'S') {
                return -1;
            }
        } else if (c == 'S') {
            if (comp == 'R') {
                return -1;
            } else if (comp == 'P') {
                return 1;
            }
        }
        return 0;
    }
}
