import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int wordCnt = Integer.parseInt(br.readLine());
            HashMap<String, HashMap<String, Integer>> wordMap = new HashMap<>();
            HashMap<String, Integer> shortWordCnt = new HashMap<>();

            for (int i = 0; i < wordCnt; i++) {
                char[] word = br.readLine().toCharArray();
                if (word.length <= 2) {
                    String shortWord = String.valueOf(word);

                    int appearedCnt = shortWordCnt.getOrDefault(shortWord, 0);
                    shortWordCnt.put(shortWord, appearedCnt + 1);
                } else {
                    String startAndLast = combineFirstAndLast(word);
                    String sortedMiddle = sortMiddle(word);

                    if (!wordMap.containsKey(startAndLast)) {
                        wordMap.put(startAndLast, new HashMap<>());
                    }

                    int appearedCnt = wordMap.get(startAndLast).getOrDefault(sortedMiddle, 0);
                    wordMap.get(startAndLast).put(sortedMiddle, appearedCnt + 1);
                }
            }

            int sentenceCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < sentenceCnt; i++) {
                String[] words = br.readLine().split(" ");
                int interpretableCase = 1;
                for (String word : words) {
                    char[] trimmedWord = word.trim().toCharArray();

                    if (trimmedWord.length <= 2) {
                        interpretableCase *= shortWordCnt.getOrDefault(word, 0);
                    } else {
                        String startAndLast = combineFirstAndLast(trimmedWord);
                        String sortedMiddle = sortMiddle(trimmedWord);

                        if (!wordMap.containsKey(startAndLast)) {
                            interpretableCase = 0;
                        } else {
                            interpretableCase *= wordMap.get(startAndLast).getOrDefault(sortedMiddle, 0);
                        }
                    }
                }

                sb.append(interpretableCase).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static String sortMiddle(char[] str) {
        char[] middle = Arrays.copyOfRange(str, 1, str.length - 1);
        Arrays.sort(middle);

        return String.valueOf(middle);
    }

    public static String combineFirstAndLast(char[] str) {
        return String.valueOf(str[0]) + str[str.length - 1];
    }
}
