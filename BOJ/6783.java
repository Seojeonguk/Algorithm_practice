import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int lineCnt = Integer.parseInt(br.readLine());
        int sCnt = 0;
        int tCnt = 0;

        for (int lineNum = 0; lineNum < lineCnt; lineNum++) {
            char[] line = br.readLine().toCharArray();
            for (int idx = 0; idx < line.length; idx++) {
                char upperC = Character.toUpperCase(line[idx]);

                if (upperC == 'S') {
                    sCnt++;
                } else if (upperC == 'T') {
                    tCnt++;
                }
            }
        }

        sb.append(sCnt >= tCnt ? "French" : "English");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
