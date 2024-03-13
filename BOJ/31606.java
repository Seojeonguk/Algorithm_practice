import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int BANANA_CNT = 3;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int appleCnt = Integer.parseInt(br.readLine());
        int orangeCnt = Integer.parseInt(br.readLine());

        sb.append(appleCnt + orangeCnt + BANANA_CNT);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
