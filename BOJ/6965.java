import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int textCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < textCnt; i++) {
            String[] words = br.readLine().split(" ");
            for (String word : words) {
                sb.append(word.length() == 4 ? "****" : word).append(" ");
            }
            sb.append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
