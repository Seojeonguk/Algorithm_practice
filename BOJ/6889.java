import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int adjectiveCnt = Integer.parseInt(br.readLine());
        int nounCnt = Integer.parseInt(br.readLine());

        String[] adjectives = new String[adjectiveCnt];
        String[] nouns = new String[nounCnt];

        for(int i=0;i<adjectiveCnt;i++) {
            adjectives[i] = br.readLine();
        }
        for(int i=0;i<nounCnt;i++) {
            nouns[i] = br.readLine();
        }

        for(String adjective : adjectives) {
            for(String noun : nouns) {
                sb.append(adjective)
                        .append(" as ")
                        .append(noun)
                        .append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
