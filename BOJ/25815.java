import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int catsYear = Integer.parseInt(st.nextToken());
        int catsMonth = Integer.parseInt(st.nextToken());

        int humanYear = 0, humanMonth = 0;
        if (catsYear >= 1) {
            humanYear += 15;
        }
        if (catsYear >= 2) {
            humanYear += 9;
        }
        if (catsYear >= 3) {
            humanYear += (catsYear - 2) * 4;
        }

        if (catsYear < 1) {
            humanMonth = catsMonth * 15;
        } else if (catsYear < 2) {
            humanMonth = catsMonth * 9;
        } else {
            humanMonth = catsMonth * 4;
        }

        sb.append(humanYear + humanMonth / 12).append(" ").append(humanMonth % 12);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
