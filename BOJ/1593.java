import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int findWordLength = Integer.parseInt(st.nextToken());
        int muralPaintingLength = Integer.parseInt(st.nextToken());

        char[] findWord = br.readLine().toCharArray();
        char[] muralPainting = br.readLine().toCharArray();

        int findMatchingSubStringCnt = findMatchingSubString(findWord, muralPainting);
        sb.append(findMatchingSubStringCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findMatchingSubString(char[] findWord, char[] muralPainting) {
        int[] appearedFindWord = new int[52];
        for (char c : findWord) {
            updateAppearance(c, appearedFindWord, 1);
        }

        int[] appearedMuralPainting = new int[52];

        int start = 0, length = 0, ans = 0;
        for (char c : muralPainting) {
            updateAppearance(c, appearedMuralPainting, 1);
            length++;

            if (length == findWord.length) {
                if (Arrays.equals(appearedFindWord, appearedMuralPainting)) {
                    ans++;
                }

                updateAppearance(muralPainting[start], appearedMuralPainting, -1);
                start++;
                length--;
            }
        }

        return ans;
    }

    public static void updateAppearance(char c, int[] count, int increment) {
        if (Character.isLowerCase(c)) {
            count[c - 'a'] += increment;
        } else {
            count[c - 'A' + 26] += increment;
        }
    }
}
