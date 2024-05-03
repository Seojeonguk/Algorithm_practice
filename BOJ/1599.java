import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static final String MINSIK_LANGUAGES_PRIORITY = "abkdeghilmncoprstuwy";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int wordCnt = Integer.parseInt(br.readLine());

            String[] words = new String[wordCnt];
            for (int i = 0; i < wordCnt; i++) {
                words[i] = br.readLine();
            }

            Arrays.sort(words, (o1, o2) -> {
                String s1 = o1.replace("ng", "c");
                String s2 = o2.replace("ng", "c");

                int minLength = Math.min(s1.length(), s2.length());

                for (int idx = 0; idx < minLength; idx++) {
                    char c1 = s1.charAt(idx);
                    char c2 = s2.charAt(idx);

                    if (c1 != c2) {
                        int c1Idx = MINSIK_LANGUAGES_PRIORITY.indexOf(c1);
                        int c2Idx = MINSIK_LANGUAGES_PRIORITY.indexOf(c2);

                        return Integer.compare(c1Idx, c2Idx);
                    }
                }

                return Integer.compare(s1.length(), s2.length());
            });

            for (String word : words) {
                sb.append(word).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
