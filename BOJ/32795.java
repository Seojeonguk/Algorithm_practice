import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());

            for (int tc = 0; tc < testCase; tc++) {
                char[] originalStr = br.readLine().toCharArray();
                char[] abbreviation = br.readLine().toCharArray();

                boolean[] isAppearedOriginalStr = new boolean[26];
                boolean[] isAppearedAbbreviation = new boolean[26];

                calAppearedStr(originalStr, isAppearedOriginalStr);
                calAppearedStr(abbreviation, isAppearedAbbreviation);

                boolean isAllContains = true;
                for (int i = 0; i < 26; i++) {
                    if (isAppearedAbbreviation[i] && !isAppearedOriginalStr[i]) {
                        isAllContains = false;
                        break;
                    }
                }

                sb.append(isAllContains ? "YES" : "NO").append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static void calAppearedStr(char[] str, boolean[] appearedCounts) {
        for (char c : str) {
            appearedCounts[c - 'a'] = true;
        }
    }
}
