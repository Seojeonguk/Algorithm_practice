import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            char[] boxLetters = br.readLine().toCharArray();
            int[] boxLetterCounts = new int[26];

            for (char letter : boxLetters) {
                boxLetterCounts[letter - 'A']++;
            }

            int wordCnt = Integer.parseInt(br.readLine());
            while (wordCnt-- > 0) {
                int[] tempBoxLetterCounts = new int[26];
                System.arraycopy(boxLetterCounts, 0, tempBoxLetterCounts, 0, 26);

                char[] wordLetters = br.readLine().toCharArray();
                for (char letter : wordLetters) {
                    tempBoxLetterCounts[letter - 'A']--;
                }

                boolean isPossible = true;
                for (int i = 0; i < tempBoxLetterCounts.length; i++) {
                    if (tempBoxLetterCounts[i] < 0) {
                        isPossible = false;
                    }
                }

                sb.append(isPossible ? "YES" : "NO").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
