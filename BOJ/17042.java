import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        boolean[] isObey = new boolean[26];
        char obeyedWizard = br.readLine().charAt(0);
        isObey[obeyedWizard - 'A'] = true;
        int duelCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < duelCnt; i++) {
            st = new StringTokenizer(br.readLine());
            char winner = st.nextToken().charAt(0);
            char loser = st.nextToken().charAt(0);

            if (loser == obeyedWizard) {
                obeyedWizard = winner;
                isObey[obeyedWizard - 'A'] = true;
            }
        }

        int obeyedCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (isObey[i]) {
                obeyedCnt++;
            }
        }
        sb.append(String.format("%c\n%d", obeyedWizard, obeyedCnt));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
