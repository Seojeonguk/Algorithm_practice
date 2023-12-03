import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final double PI = 3.14159265358979323846d;

    public static void main(String[] args) throws Exception {
        double a = Double.parseDouble(br.readLine());

        double r = Math.sqrt(a / PI) + 1.0d;

        sb.append(r * r * 4.0d);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
