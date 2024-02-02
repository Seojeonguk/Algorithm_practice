import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();

        HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'o', 'i', 'u'));

        int vowelCount = calVowelCount(str, vowels);

        vowels.add('y');
        int supposeYVowelCount = calVowelCount(str, vowels);

        sb.append(vowelCount).append(" ").append(supposeYVowelCount);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calVowelCount(char[] str, HashSet<Character> vowels) {
        int vowelCount = 0;
        for (int i = 0; i < str.length; i++) {
            if (vowels.contains(str[i])) {
                vowelCount++;
            }
        }

        return vowelCount;
    }
}
