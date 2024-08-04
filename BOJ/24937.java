import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String LEAF_BEST_LOVE_STRING = "SciComLove";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int commandCnt = Integer.parseInt(br.readLine());
            commandCnt %= LEAF_BEST_LOVE_STRING.length();

            sb.append(LEAF_BEST_LOVE_STRING, commandCnt, LEAF_BEST_LOVE_STRING.length())
                    .append(LEAF_BEST_LOVE_STRING, 0, commandCnt);

            bw.write(sb.toString());
        }
    }
}
