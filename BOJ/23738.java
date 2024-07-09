import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    static final Map<Character, String> RUSSIAN = Map.of(
            'B', "v",
            'E', "ye",
            'H', "n",
            'P', "r",
            'C', "s",
            'Y', "u",
            'X', "h"
    );

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] words = br.readLine().toCharArray();
            sb.append(readRussian(words));

            bw.write(sb.toString());
        }
    }

    public static String readRussian(char[] words) {
        StringBuilder russian = new StringBuilder();
        for (char c : words) {
            russian.append(RUSSIAN.getOrDefault(c, String.valueOf(Character.toLowerCase(c))));
        }

        return russian.toString();
    }
}
