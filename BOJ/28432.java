import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, questionIdx;
    static String[] wordChains, candidateWords;
    static char first,last;
    static Set<String> appearedWordChains = new HashSet<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        wordChains = new String[n];
        for(int idx=0;idx<n;idx++) {
            wordChains[idx] = br.readLine();
            appearedWordChains.add(wordChains[idx]);
            if(wordChains[idx].equals("?")) {
                questionIdx = idx;
            }
        }

        m = Integer.parseInt(br.readLine());
        candidateWords = new String[m];
        for(int idx=0;idx<m;idx++) {
            boolean isPossibleFront= (questionIdx == 0 ? true : false);
            boolean isPossibleBack = (questionIdx == n-1 ? true : false);
            candidateWords[idx] = br.readLine();

            if(questionIdx != 0) {
                String frontWord = wordChains[questionIdx-1];
                isPossibleFront = (candidateWords[idx].charAt(0) == frontWord.charAt(frontWord.length()-1));
            }
            if(questionIdx != n-1) {
                String backWord = wordChains[questionIdx+1];
                isPossibleBack = (candidateWords[idx].charAt(candidateWords[idx].length()-1) == backWord.charAt(0));
            }

            if(isPossibleFront && isPossibleBack && !appearedWordChains.contains(candidateWords[idx])) {
                sb.append(candidateWords[idx]);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
