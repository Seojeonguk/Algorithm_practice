import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        BigDecimal a = BigDecimal.valueOf(Double.parseDouble(st.nextToken()));
        BigDecimal answer = BigDecimal.ONE;
        int b = Integer.parseInt(st.nextToken());
        for (int i = 0; i < b; i++) {
            answer = answer.multiply(a);
        }
        sb.append(answer.toPlainString());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
