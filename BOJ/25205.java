import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final char[] VOWEL_INPUTS = {'k', 'i', 'j', 'u', 'h', 'y', 'n', 'b', 'm', 'l', 'o', 'p'};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int length = Integer.parseInt(br.readLine());
            char[] inputs = br.readLine().toCharArray();

            sb.append(isVowel(inputs[length - 1]) ? 0 : 1);

            bw.write(sb.toString());
        }
    }

    public static boolean isVowel(char c) {
        for (char vowelInput : VOWEL_INPUTS) {
            if (vowelInput == c) {
                return true;
            }
        }

        return false;
    }
}
