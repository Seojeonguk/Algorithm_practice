import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int shifting = Integer.parseInt(st.nextToken());
            int idx = word.length() - shifting;

            sb.append(String.format("Shifting %s by %d positions gives us: %s\n", word, shifting, word.substring(idx).concat(word.substring(0, idx))));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
