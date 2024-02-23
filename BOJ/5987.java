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

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer repeatInfo = new StringTokenizer(br.readLine());
            int subStrStartIdx = Integer.parseInt(repeatInfo.nextToken());
            int repeatCnt = Integer.parseInt(repeatInfo.nextToken());
            String str = repeatInfo.nextToken();

            for (int repeat = 0; repeat < repeatCnt; repeat++) {
                str = str.substring(subStrStartIdx).concat(str);
            }

            sb.append(str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
