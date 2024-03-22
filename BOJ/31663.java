import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int wordCnt = Integer.parseInt(br.readLine());
        char[][] words = new char[wordCnt][];
        int maxWordLength = 0;
        for (int wordNum = 0; wordNum < wordCnt; wordNum++) {
            words[wordNum] = br.readLine().toCharArray();
            maxWordLength = Math.max(maxWordLength, words[wordNum].length);
        }

        for (int idx = 0; idx < maxWordLength; idx++) {
            int charCnt = 0;
            int charSum = 0;
            for (int wordNum = 0; wordNum < wordCnt; wordNum++) {
                if (idx < words[wordNum].length) {
                    charSum += (words[wordNum][idx] - 'a');
                    charCnt++;
                }
            }
            sb.append((char) ('a' + (charSum / charCnt)));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
