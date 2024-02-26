import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String q = st.nextToken();
            String r = st.nextToken();

            int smallestBase = 0;
            for (int i = 2; i <= 16; i++) {
                try {
                    long pp = Long.parseLong(p, i);
                    long qq = Long.parseLong(q, i);
                    long rr = Long.parseLong(r, i);

                    if (pp * qq == rr) {
                        smallestBase = i;
                        break;
                    }
                } catch (Exception e) {
                    continue;
                }
            }

            sb.append(smallestBase).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
