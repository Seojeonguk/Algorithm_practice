import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int diff = Integer.parseInt(st.nextToken());
        int rabbitStep = Integer.parseInt(st.nextToken());
        int dogStep = Integer.parseInt(st.nextToken());

        int stepDiff = dogStep - rabbitStep;

        sb.append((diff + stepDiff - 1) / stepDiff);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
