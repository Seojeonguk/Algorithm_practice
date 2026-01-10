import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] id = br.readLine().toCharArray();
        boolean[] isExists = new boolean[26];

        for (char c : id) {
            isExists[c - 'a'] = true;
        }

        char[] printedStr = br.readLine().toCharArray();
        for (char c : printedStr) {
            if (!isExists[c - 'a']) {
                sb.append(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
