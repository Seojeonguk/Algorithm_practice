import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int wordCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());
        int[] wordToBit = new int[wordCnt];
        for (int idx = 0; idx < wordCnt; idx++) {
            String word = br.readLine();
            int bit = 0;
            for (int j = 0; j < word.length(); j++) {
                bit |= (1 << (word.charAt(j) - 'a'));
            }
            wordToBit[idx] = bit;
        }

        int knowAlphabetToBit = Integer.MAX_VALUE;
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            char alphabet = st.nextToken().charAt(0);
            if (query == 1) {
                knowAlphabetToBit &= ~(1 << (alphabet - 'a'));
            } else {
                knowAlphabetToBit |= (1 << (alphabet - 'a'));
            }

            int completeKnowingWordCnt = 0;
            for (int idx = 0; idx < wordCnt; idx++) {
                completeKnowingWordCnt += ((wordToBit[idx] & knowAlphabetToBit) == wordToBit[idx] ? 1 : 0);
            }
            sb.append(completeKnowingWordCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
