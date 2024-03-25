import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int wordCnt = Integer.parseInt(br.readLine());
        String[] words = new String[wordCnt];
        for (int idx = 0; idx < wordCnt; idx++) {
            words[idx] = br.readLine();
        }

        Arrays.sort(words);

        int cnt = 1;
        for (int i = wordCnt - 2; i >= 0; i--) {
            if (!words[i + 1].startsWith(words[i])) {
                cnt++;
            }
        }

        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
