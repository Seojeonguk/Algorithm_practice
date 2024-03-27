import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int wordCnt = Integer.parseInt(br.readLine());
        String[] words = new String[wordCnt];
        for (int wordNum = 0; wordNum < wordCnt; wordNum++) {
            words[wordNum] = br.readLine();
        }

        boolean[] canMakeStr = new boolean[str.length() + 1];
        canMakeStr[str.length()] = true;

        for (int i = str.length(); i >= 0; i--) {
            if (!canMakeStr[i]) {
                continue;
            }

            for (int wordNum = 0; wordNum < wordCnt; wordNum++) {
                int startIdx = i - words[wordNum].length();
                if (startIdx < 0) {
                    continue;
                }
                String subStr = str.substring(i - words[wordNum].length(), i);
                if (subStr.equals(words[wordNum])) {
                    canMakeStr[startIdx] = true;
                }
            }
        }

        sb.append(canMakeStr[0] ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
