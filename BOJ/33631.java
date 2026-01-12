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
        int haveFlour = Integer.parseInt(st.nextToken());
        int haveChocolate = Integer.parseInt(st.nextToken());
        int haveEgg = Integer.parseInt(st.nextToken());
        int haveButter = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int flourPerCookie = Integer.parseInt(st.nextToken());
        int chocolatePerCookie = Integer.parseInt(st.nextToken());
        int eggPerCookie = Integer.parseInt(st.nextToken());
        int butterPerCookie = Integer.parseInt(st.nextToken());

        int queryCnt = Integer.parseInt(br.readLine());
        int madeCookieCnt = 0;
        while (queryCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (query == 1) {
                if ((num * flourPerCookie <= haveFlour) &&
                        (num * chocolatePerCookie <= haveChocolate) &&
                        (num * eggPerCookie <= haveEgg) &&
                        (num * butterPerCookie <= haveButter)
                ) {
                    haveFlour -= num * flourPerCookie;
                    haveChocolate -= num * chocolatePerCookie;
                    haveEgg -= num * eggPerCookie;
                    haveButter -= num * butterPerCookie;
                    madeCookieCnt += num;
                    sb.append(madeCookieCnt).append("\n");
                } else {
                    sb.append("Hello, siumii").append("\n");
                }
            } else if (query == 2) {
                haveFlour += num;
                sb.append(haveFlour).append("\n");
            } else if (query == 3) {
                haveChocolate += num;
                sb.append(haveChocolate).append("\n");
            } else if (query == 4) {
                haveEgg += num;
                sb.append(haveEgg).append("\n");
            } else if (query == 5) {
                haveButter += num;
                sb.append(haveButter).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
