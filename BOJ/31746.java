import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String str = "SciComLove";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(str);
        int reverseCnt = Integer.parseInt(br.readLine());
        if (reverseCnt % 2 == 1) {
            sb.reverse();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
