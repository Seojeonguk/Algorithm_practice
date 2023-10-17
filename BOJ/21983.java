import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        double area = Double.parseDouble(br.readLine());
        double lineLength = Math.sqrt(area * 2.0f / 3.0f / Math.sqrt(3));
        
        sb.append(6 * lineLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
