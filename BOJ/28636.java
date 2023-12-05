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
        int n = Integer.parseInt(br.readLine());

        int sumSeconds = 0;
        for (int i = 0; i < n; i++) {
            String[] hours = br.readLine().split(":");
            int minute = Integer.parseInt(hours[0]);
            int second = Integer.parseInt(hours[1]);

            sumSeconds += minute * 60 + second;
        }

        sb.append(String.format("%02d:%02d:%02d", sumSeconds / 3600, (sumSeconds % 3600) / 60, sumSeconds % 3600 % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
