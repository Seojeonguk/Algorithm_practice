import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final int COOKIE_PRICE = 900 + 60 + 600 + 170 + 160 + 110;

    public static void main(String[] args) throws Exception {
        int money = Integer.parseInt(br.readLine());
        sb.append(money / COOKIE_PRICE);

        bw.write(sb.toString());
        bw.flush();
    }
}
