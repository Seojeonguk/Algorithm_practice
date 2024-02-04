import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int ai = Integer.parseInt(a);
        int bi = Integer.parseInt(b);
        int ci = Integer.parseInt(c);

        sb.append(ai + bi - ci).append("\n");
        sb.append(Integer.parseInt(a + b) - ci);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
