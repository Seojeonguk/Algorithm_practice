import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        char[] encodingStr = br.readLine().toCharArray();

        for (int idx = 0; idx < encodingStr.length; idx++) {
            int moved = (3 * (idx + 1) + k) % 26;
            sb.append((char) ((encodingStr[idx] - 'A' - moved + 26) % 26 + 'A'));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
