import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int correctProblem = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.contains("+")) {
                correctProblem++;
            }
        }
        sb.append(correctProblem);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
