import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer tapes = new StringTokenizer(br.readLine());

            int minTape = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int tape = Integer.parseInt(tapes.nextToken());
                minTape = Math.min(minTape, tape);
            }

            sb.append(minTape).append(".00");

            bw.write(sb.toString());
        }
    }
}
