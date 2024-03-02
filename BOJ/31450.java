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

        StringTokenizer olympicInfo = new StringTokenizer(br.readLine());
        int medalCnt = Integer.parseInt(olympicInfo.nextToken());
        int kidCnt = Integer.parseInt(olympicInfo.nextToken());

        sb.append(medalCnt % kidCnt == 0 ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
