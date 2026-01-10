import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {

        private final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

        private StringBuilder sb = new StringBuilder();

        public void solve() throws IOException {
            int testCase = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCase; i++) {
                char[] str = br.readLine().toCharArray();

                int vowelCnt = 0;

                for (int idx = 0; idx < str.length; idx++) {
                    if (isVowel(str[idx])) {
                        vowelCnt++;
                    }
                }

                sb.append("The number of vowels in ").append(str).append(" is ").append(vowelCnt).append(".\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }

        public boolean isVowel(char c) {
            for (char VOWEL : VOWELS) {
                if (VOWEL == c) {
                    return true;
                }
            }

            return false;
        }
    }
}
