import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final String WIN = "Win";
    static final String LOSE = "Lose";

    public static void main(String[] args) throws Exception {
        char[] bands = br.readLine().toCharArray();

        sb.append(bands[0] != bands[bands.length - 1] ? WIN : LOSE);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
