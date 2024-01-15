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
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            String witchExpression = br.readLine();
            boolean isContainSpell = containSpell(witchExpression);

            sb.append(String.format("Case #%d: %s\n", testCase, isContainSpell ? "Spell!" : "Nothing."));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean containSpell(String str) {
        if (str.length() < 5) {
            return false;
        }

        int strLength = str.length();
        for (int subStrLength = 5; subStrLength <= strLength; subStrLength++) {
            for (int startIdx = 0; startIdx + subStrLength <= strLength; startIdx++) {
                String subStr = str.substring(startIdx, startIdx + subStrLength);

                for (int startEndIdx = 2; subStrLength - 2 * startEndIdx >= 1; startEndIdx++) {
                    int endStartIdx = subStrLength - startEndIdx;
                    String start = subStr.substring(0, startEndIdx);
                    String middle = subStr.substring(startEndIdx, endStartIdx);
                    String end = subStr.substring(endStartIdx);

                    if (!start.equals(end)) {
                        continue;
                    }
                    int startVowelCnt = getVowelCnt(start);
                    int middleVowelCnt = getVowelCnt(middle);

                    if (startVowelCnt >= 2 && middleVowelCnt >= 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int getVowelCnt(String str) {
        int vowelCnt = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCnt++;
            }
        }
        return vowelCnt;
    }
}
