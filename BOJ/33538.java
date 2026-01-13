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
        int meter = Integer.parseInt(br.readLine());
        int studentCnt = Integer.parseInt(br.readLine());
        double targetTime = Double.parseDouble(br.readLine());

        boolean hasFastestStudent = false;
        while (studentCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double frontCrawl = Double.parseDouble(st.nextToken());
            double backCrawl = Double.parseDouble(st.nextToken());

            double time = (meter / frontCrawl) + (meter / backCrawl);
            if (time < targetTime) {
                hasFastestStudent = true;
                break;
            }
        }

        sb.append(hasFastestStudent ? "HOPE" : "DOOMED");

        bw.write(sb.toString());
        bw.flush();
    }
}
