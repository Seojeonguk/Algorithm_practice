import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int[] appeared = new int[26];
        for (int i = 0; i < length / 2; i++) {
            appeared[str[i] - 'a']++;
            appeared[str[length - 1 - i] - 'a']++;
        }

        boolean canMakePalindrome = true;
        for (int i = 0; i < 26; i++) {
            canMakePalindrome &= (appeared[i] % 2 == 0);
        }

        sb.append(canMakePalindrome ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
