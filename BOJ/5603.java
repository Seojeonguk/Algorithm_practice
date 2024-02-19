import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int commandCnt = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < commandCnt; i++) {
            StringBuilder commandResult = new StringBuilder();
            char[] strs = str.toCharArray();

            int idx = 0;
            while (idx < strs.length) {
                int sameAppearedCnt = 1;
                while (idx + sameAppearedCnt < strs.length) {
                    if (strs[idx + sameAppearedCnt] == strs[idx]) {
                        sameAppearedCnt++;
                    } else {
                        break;
                    }
                }
                commandResult.append(sameAppearedCnt).append(strs[idx]);
                idx += sameAppearedCnt;
            }
            str = commandResult.toString();
        }

        sb.append(str);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
