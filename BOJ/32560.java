import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();

            int[][] appearedAlphabets = new int[2][26];

            calAppearedAlphabets(a, appearedAlphabets, 0);
            calAppearedAlphabets(b, appearedAlphabets, 1);

            for (int i = 0; i < 26; i++) {
                int moreAppearedCnt = Math.max(appearedAlphabets[0][i], appearedAlphabets[1][i]);
                for (int j = 0; j < moreAppearedCnt; j++) {
                    sb.append((char) (i + 'a'));
                }
            }

            bw.write(sb.toString());
        }
    }

    public static void calAppearedAlphabets(char[] a, int[][] appearedAlphabets, int i) {
        for (char c : a) {
            appearedAlphabets[i][c - 'a']++;
        }
    }
}
