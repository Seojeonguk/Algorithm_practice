import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int planetInXCnt = Integer.parseInt(st.nextToken());
        int planetInYCnt = Integer.parseInt(st.nextToken());

        int canVisitedPlanetCnt = Math.min(planetInXCnt, planetInYCnt) * 2 + (planetInXCnt == planetInYCnt ? 0 : 1);

        sb.append(canVisitedPlanetCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
