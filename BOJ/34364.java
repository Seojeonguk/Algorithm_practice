import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int letterLength = Integer.parseInt(st.nextToken());
        char[] str = st.nextToken().toCharArray();

        long added = 1;
        for (int i = 0; i < letterLength; i++) {
            sb.append((char) ((str[i] - 'A' + added) % 26 + 'A'));
            added *= 2;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
