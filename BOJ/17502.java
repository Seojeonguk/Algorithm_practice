import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int length = Integer.parseInt(br.readLine());
            char[] deletedCharacters = br.readLine().toCharArray();

            for (int idx = 0; idx <= length / 2; idx++) {
                if (deletedCharacters[idx] == '?' && deletedCharacters[length - idx - 1] != '?') {
                    deletedCharacters[idx] = deletedCharacters[length - idx - 1];
                } else if (deletedCharacters[idx] != '?' && deletedCharacters[length - idx - 1] == '?') {
                    deletedCharacters[length - idx - 1] = deletedCharacters[idx];
                } else if (deletedCharacters[idx] == '?' && deletedCharacters[length - idx - 1] == '?') {
                    deletedCharacters[idx] = deletedCharacters[length - idx - 1] = 'a';
                }
            }

            sb.append(deletedCharacters);

            bw.write(sb.toString());
        }
    }
}
