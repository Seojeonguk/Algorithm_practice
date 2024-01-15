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

    static final String KING = "a king";
    static final String QUEEN = "a queen";
    static final String NOBODY = "nobody";

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            String countryName = br.readLine();
            char lastCharacter = countryName.charAt(countryName.length() - 1);

            sb.append(String.format("Case #%d: %s is ruled by %s.\n", testCase, countryName, calRuled(Character.toLowerCase(lastCharacter))));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String calRuled(char c) {
        if (c == 'y') {
            return NOBODY;
        }

        boolean isVowel = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
        return (isVowel ? QUEEN : KING);
    }
}
