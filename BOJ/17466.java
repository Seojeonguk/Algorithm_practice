import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        Long n = Long.parseLong(st.nextToken());
        Long mod = Long.parseLong(st.nextToken());
 
        Long x = 1L;
        for(int i = 1 ; i <= n ; i++) {
            x = (x * i) % mod;
        }

        sb.append(x);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}