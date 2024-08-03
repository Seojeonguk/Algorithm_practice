import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] encryptedStrings = br.readLine().toCharArray();

            sb.append(Decrypt(encryptedStrings));

            bw.write(sb.toString());
        }
    }

    public static String Decrypt(char[] encryptedStrings) {
        StringBuilder decryptedString = new StringBuilder();
        for (int key = 0; ; key++) {
            if ((char) (encryptedStrings[0] ^ key) == 'C') {
                for (int i = 0; i < encryptedStrings.length; i++) {
                    decryptedString.append((char) (encryptedStrings[i] ^ key));
                }
                break;
            }
        }

        return decryptedString.toString();
    }
}
