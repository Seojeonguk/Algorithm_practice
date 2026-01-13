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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int x = -1;
        int foundAns = 0;
        for (int i = 1; i <= 3; i++) {
            if (pow(a, i) + pow(b, i) + pow(c, i) == d) {
                x = i;
                foundAns += 1;
            }
        }

        if (x == -1 || foundAns > 1) {
            sb.append(-1);
        } else {
            sb.append(x);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static int pow(int a, int b) {
        int c = 1;
        for (int i = 0; i < b; i++) {
            c *= a;
        }

        return c;
    }
}
