import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        long squareCnt = Long.parseLong(br.readLine());
        long length = 1;

        while (squareCnt >= length * length) {
            squareCnt -= length * length;
            length++;
        }

        sb.append(length - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
