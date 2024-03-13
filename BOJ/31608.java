import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int strLength = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();

        int diffCnt = 0;
        for (int idx = 0; idx < strLength; idx++) {
            if (s[idx] != t[idx]) {
                diffCnt++;
            }
        }

        sb.append(diffCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
