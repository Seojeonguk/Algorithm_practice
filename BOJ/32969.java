import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String DIGITAL_HUMANITIES = "digital humanities";
    static final String[] DIGITAL_HUMANITIES_DECISION_WORDS = {
            "social",
            "history",
            "language",
            "literacy"
    };

    static final String PUBLIC_BIGDATA = "public bigdata";
    static final String[] PUBLIC_BIGDATA_DECISION_WORDS = {
            "bigdata",
            "public",
            "society"
    };

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String thesisTopic = br.readLine().toLowerCase();

            int track = 0;

            for (String word : DIGITAL_HUMANITIES_DECISION_WORDS) {
                if (thesisTopic.contains(word)) {
                    track = 1;
                }
            }

            for (String word : PUBLIC_BIGDATA_DECISION_WORDS) {
                if (thesisTopic.contains(word)) {
                    track = 2;
                }
            }

            sb.append(track == 1 ? DIGITAL_HUMANITIES : PUBLIC_BIGDATA);

            bw.write(sb.toString());
        }
    }
}
