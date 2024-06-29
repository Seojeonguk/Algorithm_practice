import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int analyzedLineCnt = Integer.parseInt(br.readLine());
            int[][] appearedCounts = new int[2][26];

            for (int line = 0; line < analyzedLineCnt; line++) {
                char[] analyzedLine = br.readLine().toCharArray();
                for (char c : analyzedLine) {
                    if (c == ' ') {
                        continue;
                    }

                    if (Character.isLowerCase(c)) {
                        appearedCounts[0][c - 'a']++;
                    } else {
                        appearedCounts[1][c - 'A']++;
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 26; j++) {
                    if (appearedCounts[i][j] == 0) {
                        continue;
                    }

                    sb.append((char) (j + (i == 0 ? 'a' : 'A'))).append(" ").append(appearedCounts[i][j]).append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
