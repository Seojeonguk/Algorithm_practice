import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    final static String MOST_LOVE_STRING = "SciComLove";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String editedStr = br.readLine();

            int changedCharacterCnt = 0;

            int strLength = MOST_LOVE_STRING.length();
            for (int idx = 0; idx < strLength; idx++) {
                if (MOST_LOVE_STRING.charAt(idx) != editedStr.charAt(idx)) {
                    changedCharacterCnt++;
                }
            }

            sb.append(changedCharacterCnt);

            bw.write(sb.toString());
        }
    }
}
