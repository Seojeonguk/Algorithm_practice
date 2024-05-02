import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int CHEERING_PHRASE_COUNT = 3;
    static final String GLOBAL = "GLOBAL";
    static final String NOT_GLOBAL = "PONIX";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            boolean isStartL = false, isStartK = false, isStartP = false;
            for (int i = 0; i < CHEERING_PHRASE_COUNT; i++) {
                String cheeringPhrase = br.readLine();
                char startC = cheeringPhrase.charAt(0);
                if (startC == 'l') {
                    isStartL = true;
                } else if (startC == 'k') {
                    isStartK = true;
                } else if (startC == 'p') {
                    isStartP = true;
                }
            }

            sb.append(isStartL && isStartK && isStartP ? GLOBAL : NOT_GLOBAL);

            bw.write(sb.toString());
        }
    }
}
