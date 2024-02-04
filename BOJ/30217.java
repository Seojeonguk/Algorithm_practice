import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();

        sb.append(combineTwoString(str1, str2));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String combineTwoString(String s1, String s2) {
        int appearFirstVowel = s1.length();
        for (int i = 1; i < s1.length(); i++) {
            if (isVowel(s1.charAt(i))) {
                appearFirstVowel = i;
                break;
            }
        }

        int appearSecondVowel = -1;
        for (int i = s2.length() - 2; i >= 0; i--) {
            if (isVowel(s2.charAt(i))) {
                appearSecondVowel = i;
                break;
            }
        }

        String ret = "";
        if (appearSecondVowel != -1) {
            ret = s1.substring(0, appearFirstVowel).concat(s2.substring(appearSecondVowel));
        } else if (appearFirstVowel != s1.length()) {
            ret = s1.substring(0, appearFirstVowel + 1).concat(s2);
        } else {
            ret = s1.concat("o").concat(s2);
        }
        return ret;
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
