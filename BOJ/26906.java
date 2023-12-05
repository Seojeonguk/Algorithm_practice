import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int alphabetCnt = Integer.parseInt(br.readLine());
        HashMap<String, Character> patterns = new HashMap<>();

        for (int i = 0; i < alphabetCnt; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            String pattern = st.nextToken();

            patterns.put(pattern, c);
        }

        String str = br.readLine();
        for (int i = 0; i < str.length(); i += 4) {
            String subString = str.substring(i, i + 4);
            sb.append(patterns.containsKey(subString) ? patterns.get(subString) : "?");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
