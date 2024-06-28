import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static final int TOTAL_TULIP = 15000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int tulipCnt = Integer.parseInt(br.readLine());

            HashSet<Integer> denotedTulipsSet = new HashSet<>();
            StringTokenizer denotedTulips = new StringTokenizer(br.readLine());
            for (int i = 0; i < tulipCnt; i++) {
                int denotedTulip = Integer.parseInt(denotedTulips.nextToken());
                denotedTulipsSet.add(denotedTulip);
            }

            sb.append(TOTAL_TULIP - denotedTulipsSet.size());

            bw.write(sb.toString());
        }
    }
}
