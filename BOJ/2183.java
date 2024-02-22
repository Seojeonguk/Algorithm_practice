import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer inputs = new StringTokenizer(br.readLine());
        int totalPlayTennis = Integer.parseInt(inputs.nextToken());
        char[] winners = inputs.nextToken().toCharArray();

        sb.append(winners[winners.length - 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
