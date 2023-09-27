import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int day = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int maxStreak = 0, currentStreak = 0;
        for (int i = 0; i < day; i++) {
            int solvingProblemCnt = Integer.parseInt(st.nextToken());
            currentStreak = (solvingProblemCnt == 0 ? 0 : currentStreak + 1);
            maxStreak = Math.max(maxStreak, currentStreak);
        }
        
        sb.append(maxStreak);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
