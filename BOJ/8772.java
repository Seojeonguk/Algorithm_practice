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
                int encryptedMessageLength = Integer.parseInt(br.readLine());
                char[] encryptedMessages = br.readLine().toCharArray();

                char firstCharacterOfOriginalMessage = br.readLine().charAt(0);

                int shift = firstCharacterOfOriginalMessage - encryptedMessages[0];

                for (char c : encryptedMessages) {
                    sb.append((char) ((c - 'a' + shift + 26) % 26 + 'a'));
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
