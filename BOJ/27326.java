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
        int teamNum = Integer.parseInt(br.readLine());
        int[] teamPersons = new int[teamNum + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < teamNum * 2 - 1; i++) {
            int team = Integer.parseInt(st.nextToken());
            teamPersons[team]++;
        }

        for (int i = 1; i <= teamNum; i++) {
            if (teamPersons[i] == 1) {
                sb.append(i);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
