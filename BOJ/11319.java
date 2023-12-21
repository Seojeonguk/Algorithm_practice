import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalSentence = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalSentence; i++) {
            String sentence = br.readLine();
            int sentenceLength = sentence.length();
            int vowels = 0, consonants = 0;
            for (int idx = 0; idx < sentenceLength; idx++) {
                char c = sentence.charAt(idx);
                if (!Character.isAlphabetic(c)) {
                    continue;
                }
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            sb.append(consonants).append(" ").append(vowels).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isVowel(char c) {
        char lowerCase = Character.toLowerCase(c);
        return (lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u');
    }
}
