import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int changedMinute = Integer.parseInt(br.readLine());
        double originalMinute = 0.5 * Math.min(changedMinute, 30) + 1.5 * Math.max(0, changedMinute - 30);

        sb.append(String.format("%.1f", originalMinute));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
