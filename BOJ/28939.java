import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int ret = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int shelfHeight = Integer.parseInt(st.nextToken());
            int shoeCnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < shoeCnt; i++) {
                int shoeSize = Integer.parseInt(st.nextToken());
                if (shoeSize * m1 < shelfHeight || shoeSize * m2 > shelfHeight * k) {
                    ret++;
                }
            }
        }

        sb.append(ret);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
