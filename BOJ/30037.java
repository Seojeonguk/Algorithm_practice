import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int sentenceCnt = Integer.parseInt(br.readLine());

        while (sentenceCnt-- > 0) {
            ArrayList<String> words = new ArrayList<>();
            for (String word : br.readLine().split(" ")) {
                if (isPunctuationMark(word.charAt(word.length() - 1))) {
                    words.add(word.substring(0, word.length() - 1));
                    words.add(word.substring(word.length() - 1));
                } else {
                    words.add(word);
                }
            }

            while (true) {
                boolean isChanged = false;
                for (int idx = 0; idx < words.size(); idx++) {
                    if (idx > 0 && "of".equals(words.get(idx)) && "Korea".equals(words.get(idx + 1)) && !isPunctuationMark(words.get(idx - 1))) {
                        isChanged = true;

                        String prevWord = words.get(idx - 1);
                        String upperPrevWord = "K-" + Character.toUpperCase(prevWord.charAt(0)) + prevWord.substring(1);

                        words.remove(idx + 1);
                        words.remove(idx);

                        words.set(idx - 1, upperPrevWord);
                        break;
                    }
                }
                if (!isChanged) {
                    break;
                }
            }

            while (true) {
                boolean isChanged = false;
                for (int idx = words.size() - 1; idx >= 0; idx--) {
                    if (words.get(idx).equals("Korea") && !isPunctuationMark(words.get(idx + 1))) {
                        isChanged = true;

                        String nextWord = words.get(idx + 1);
                        String upperNextWord = "K-" + Character.toUpperCase(nextWord.charAt(0)) + nextWord.substring(1);

                        words.set(idx + 1, upperNextWord);
                        words.remove(idx);
                        break;
                    }
                }
                if (!isChanged) {
                    break;
                }
            }

            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if (isPunctuationMark(words.get(i + 1))) {
                    sb.append(words.get(i + 1));
                    i++;
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPunctuationMark(String str) {
        if (str.length() != 1) return false;
        return isPunctuationMark(str.charAt(0));
    }

    public static boolean isPunctuationMark(char c) {
        if (c == '!') return true;
        else if (c == '?') return true;
        else if (c == ',') return true;
        else if (c == '.') return true;
        return false;
    }
}
