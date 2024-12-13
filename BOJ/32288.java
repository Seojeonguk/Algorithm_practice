import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int nicknameLength = Integer.parseInt(br.readLine());
            String nickname = br.readLine();

            sb.append(convertNickname(nickname));

            bw.write(sb.toString());
        }
    }

    public static String convertNickname(String originalNickname) {
        StringBuilder convertedNickname = new StringBuilder();

        char[] nickname = originalNickname.toCharArray();
        for (char c : nickname) {
            convertedNickname.append(c == 'I' ? 'i' : 'L');
        }

        return convertedNickname.toString();
    }
}
