import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            double l = Double.parseDouble(st.nextToken());
            double h = Double.parseDouble(st.nextToken());

            double r = l / 2.0 + 5.0;

            double ans = Math.PI * r * (2.0 * h + r);

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
