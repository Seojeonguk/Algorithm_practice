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
        int recommendWater = Integer.parseInt(st.nextToken());
        int putWater = Integer.parseInt(st.nextToken());

        sb.append((recommendWater * 81.0) / 100 <= putWater ? "yaho" : "no");

        bw.write(sb.toString());
        bw.flush();
    }
}
