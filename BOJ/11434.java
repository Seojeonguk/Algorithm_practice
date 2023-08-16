import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int contentiousCnt = Integer.parseInt(st.nextToken());
            int livingInWest = Integer.parseInt(st.nextToken());
            int livingInEast = Integer.parseInt(st.nextToken());

            int maxTotalHappiness = 0;
            for (int contentious = 0; contentious < contentiousCnt; contentious++) {
                st = new StringTokenizer(br.readLine());
                int westLikeOwn = Integer.parseInt(st.nextToken());
                int westLikeEast = Integer.parseInt(st.nextToken());
                int eastLikeWest = Integer.parseInt(st.nextToken());
                int eastLikeOwn = Integer.parseInt(st.nextToken());

                int westPickHappiness = westLikeOwn * livingInWest + eastLikeWest * livingInEast;
                int eastPickHappiness = westLikeEast * livingInWest + eastLikeOwn * livingInEast;

                maxTotalHappiness += (westPickHappiness > eastPickHappiness ? westPickHappiness : eastPickHappiness);
            }
            sb.append(String.format("Data Set %d:\n", tc + 1));
            sb.append(maxTotalHappiness).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
