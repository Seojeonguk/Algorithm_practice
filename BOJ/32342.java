import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final char[] CUTE_SOUND = {'W', 'O', 'W'};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int soundCnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < soundCnt; i++) {
                char[] sound = br.readLine().toCharArray();

                int cute = 0;
                for (int idx = 0; idx < sound.length - 2; idx++) {
                    if (sound[idx] == CUTE_SOUND[0] && sound[idx + 1] == CUTE_SOUND[1] && sound[idx + 2] == CUTE_SOUND[2]) {
                        cute++;
                    }
                }

                sb.append(cute).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
