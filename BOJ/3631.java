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

        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());
        double Z = Double.parseDouble(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        double t = X / n;
        double cur = 0;
        for (int i = 0; i < n; i++) {
            sb.append(cur).append(" ")
                    .append(0).append(" ")
                    .append(0).append(" ")
                    .append(cur + t).append(" ")
                    .append(Y).append(" ")
                    .append(Z).append("\n");

            cur += t;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
