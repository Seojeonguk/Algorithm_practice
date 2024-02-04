import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static final HashSet<String> USELESS_WORDS = new HashSet<>(Arrays.asList("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"));

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String sentence = br.readLine();
        sb.append(reduceSentence(sentence));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String reduceSentence(String str) {
        StringBuilder sb = new StringBuilder();

        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i > 0 && isUselessWord(words[i])) {
                continue;
            }
            sb.append(Character.toUpperCase(words[i].charAt(0)));
        }

        return sb.toString();
    }

    public static boolean isUselessWord(String word) {
        return USELESS_WORDS.contains(word);
    }
}
