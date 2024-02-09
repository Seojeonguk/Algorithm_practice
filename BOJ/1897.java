import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static final int MAX_WORD_LENGTH = 80;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int dictionaryCnt = Integer.parseInt(st.nextToken());

        String initWord = st.nextToken();
        String[] dictionaries = new String[dictionaryCnt];
        for (int i = 0; i < dictionaryCnt; i++) {
            dictionaries[i] = br.readLine();
        }

        String longestWord = makeMaxLongestWord(initWord, dictionaries);
        sb.append(longestWord);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String makeMaxLongestWord(String initWord, String[] dictionaries) {
        HashSet<String> passedWords = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        passedWords.add(initWord);
        q.add(initWord);

        String lastWord = null;

        while (!q.isEmpty()) {
            lastWord = q.poll();

            for (String word : dictionaries) {
                if (passedWords.contains(word)) {
                    continue;
                }
                if (canMakeWord(lastWord, word)) {
                    passedWords.add(word);
                    q.add(word);
                }
            }
        }

        return lastWord;
    }

    public static boolean canMakeWord(String str1, String str2) {
        if (str1.length() + 1 != str2.length()) {
            return false;
        }

        boolean isFindDiff = false;
        int firstStrIdx = 0;
        for (int i = 0; i < str2.length(); i++) {
            char c1 = (firstStrIdx < str1.length() ? str1.charAt(firstStrIdx++) : 'Q');
            char c2 = str2.charAt(i);

            if (c1 == c2) {
                continue;
            }

            if (isFindDiff) {
                return false;
            }

            isFindDiff = true;
            firstStrIdx--;
        }

        return true;
    }
}
