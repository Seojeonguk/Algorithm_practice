import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        int[] appeared = new int[26];
        while(testCase-- > 0) {
        	Arrays.fill(appeared,0);
        	
        	String str = br.readLine();
        	for(int idx=0; idx<str.length();idx++) {
        		char c = str.charAt(idx);
        		if(c==' ') {
        			continue;
        		}
        		appeared[c-'a']++;
        	}
        	
        	int maxAppearedCnt=0;
        	int maxAppearedIdx=0;
        	
        	for(int i=0;i<26;i++) {
        		if(appeared[maxAppearedIdx] < appeared[i]) {
        			maxAppearedIdx = i;
        			maxAppearedCnt = 1;
        		} else if(appeared[maxAppearedIdx] == appeared[i]) {
        			maxAppearedCnt++;
        		}
        	}
        	
        	if(maxAppearedCnt > 1) {
        		sb.append("?").append("\n");
        	} else {
        		sb.append((char)('a'+maxAppearedIdx)).append("\n");
        	}
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}