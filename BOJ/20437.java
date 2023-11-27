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
        int gameCnt = Integer.parseInt(br.readLine());

        while (gameCnt-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            solve(str, k);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(String str, int k) {
        ArrayList<Integer>[] appeared = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            appeared[i] = new ArrayList<>();
        }

        int length = str.length();
        for (int idx = 0; idx < length; idx++) {
            int c = str.charAt(idx) - 'a';
            appeared[c].add(idx);
        }

        int threeQuery = Integer.MAX_VALUE, fourthQuery = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j + k - 1 < appeared[i].size(); j++) {
                threeQuery = Math.min(threeQuery, appeared[i].get(j + k - 1) - appeared[i].get(j) + 1);
                fourthQuery = Math.max(fourthQuery, appeared[i].get(j + k - 1) - appeared[i].get(j) + 1);
            }
        }

        if (threeQuery == Integer.MAX_VALUE) {
            sb.append(-1).append("\n");
        } else {
            sb.append(threeQuery).append(" ").append(fourthQuery).append("\n");
        }
    }
}
