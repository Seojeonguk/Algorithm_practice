import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int idx = 0; idx < str.length; idx++) {
                sb.append((char) ((str[idx] - 'A' + 26 - i) % 26 + 'A'));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
