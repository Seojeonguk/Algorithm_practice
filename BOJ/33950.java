import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int cheerWordCnt = Integer.parseInt(br.readLine());
        while (cheerWordCnt-- > 0) {
            String cheeringWord = br.readLine();
            cheeringWord = cheeringWord.replaceAll("PO", "PHO");
            sb.append(cheeringWord).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
