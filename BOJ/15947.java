import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String[] ORIGINAL_SONG = {"baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu", "in", "bed", "tururu", "turu", "baby", "sukhwan"};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()) - 1;
        int repeatCnt = n / ORIGINAL_SONG.length;
        int nthWord = n % ORIGINAL_SONG.length;

        sb.append(ORIGINAL_SONG[nthWord]);

        if (ORIGINAL_SONG[nthWord].startsWith("tu")) {
            for (int i = 0; i < repeatCnt; i++) {
                sb.append("ru");
            }

            if (sb.length() >= 12) {
                int ruCnt = sb.length() / 2 - 1;
                sb.setLength(0);
                sb.append(String.format("tu+ru*%d", ruCnt));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
