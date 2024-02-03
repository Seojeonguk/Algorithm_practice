import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String saschaWord = br.readLine();
            int wordLength = saschaWord.length();

            int dictionaryWordCnt = Integer.parseInt(br.readLine());
            int minDiff = saschaWord.length() + 1;
            String saschaToSayWord = "";
            for (int i = 0; i < dictionaryWordCnt; i++) {
                String dictionaryWord = br.readLine();

                int diff = 0;
                for (int j = 0; j < wordLength; j++) {
                    if (saschaWord.charAt(j) != dictionaryWord.charAt(j)) {
                        diff++;
                    }
                }

                if (diff < minDiff) {
                    saschaToSayWord = dictionaryWord;
                    minDiff = diff;
                }
            }

            sb.append(saschaToSayWord).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
