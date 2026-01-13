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
        int firstMidterm = Integer.parseInt(st.nextToken());
        int secondMidterm = Integer.parseInt(st.nextToken());
        int finalExam = Integer.parseInt(st.nextToken());

        double score = firstMidterm / 4.0 + secondMidterm / 4.0 + finalExam / 2.0;
        if (score >= 90) {
            sb.append("A");
        } else if (score >= 80) {
            sb.append("B");
        } else if (score >= 70) {
            sb.append("C");
        } else if (score >= 60) {
            sb.append("D");
        } else {
            sb.append("F");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
