import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String name = br.readLine();
        int nameSize = name.length();
        int lastVowelIndex = -1;
        for (lastVowelIndex = nameSize - 1; lastVowelIndex >= 0; lastVowelIndex--) {
            char c = name.charAt(lastVowelIndex);
            char lowerC = Character.toLowerCase(c);
            if (isVowel(lowerC)) {
                break;
            }
        }

        sb.append(name, 0, lastVowelIndex + 1).append("ntry");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
