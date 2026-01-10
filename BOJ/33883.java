import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();
        int remained = (isLastSecondVowelAccent(str[str.length - 1]) ? 2 : 1);
        int accentIdx = -1;
        for (int i = str.length - 1; i >= 0; i--) {
            if (isVowel(str[i])) {
                remained -= 1;
                if (remained == 0) {
                    accentIdx = i + 1;
                    break;
                }
            }
        }

        sb.append(accentIdx);

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isLastSecondVowelAccent(char c) {
        return (c == 'n' || c == 's' || isVowel(c));
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
