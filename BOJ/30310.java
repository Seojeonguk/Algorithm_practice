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
        int forkTypes = Integer.parseInt(br.readLine());

        int[] forks = new int[forkTypes];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < forkTypes; i++) {
            int fork = Integer.parseInt(st.nextToken());
            forks[i] = fork;
        }

        Arrays.sort(forks);

        sb.append(forks[0] + forks[1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
