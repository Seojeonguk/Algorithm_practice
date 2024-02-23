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
        int charmBraceletLength = Integer.parseInt(inputs.nextToken());
        int charmCnt = Integer.parseInt(inputs.nextToken());
        int nail = Integer.parseInt(inputs.nextToken());

        for (int charmNum = 0; charmNum < charmCnt; charmNum++) {
            StringTokenizer charmInfo = new StringTokenizer(br.readLine());
            int charmLength = Integer.parseInt(charmInfo.nextToken());
            int charmLocation = Integer.parseInt(charmInfo.nextToken());

            sb.append(charmLength + Math.abs(nail - charmLocation)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
