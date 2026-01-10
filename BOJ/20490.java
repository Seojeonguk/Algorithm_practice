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
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());

        int maxLength1 = maxLength(a1, b1, c1);

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int maxLength2 = maxLength(a2, b2, c2);

        sb.append(a1 + b1 + c1 + a2 + b2 + c2 - maxLength1 - maxLength2 + Math.abs(maxLength1 - maxLength2));

        bw.write(sb.toString());
        bw.flush();
    }

    public static int maxLength(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
