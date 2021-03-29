import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String s;
	static int[] fail;
	static int n,cnt,ans;
	static int zero;
	
	
	public static void main(String[] args) throws Exception {
		while(true) {
			s = br.readLine();
			if(s.equals(".")) break;
			
			cnt=0;
			zero=1;
			n = s.length();
			fail = new int[n];
			
			for(int i=1,j=0;i<n;i++) {
				while(j>0 && s.charAt(i) != s.charAt(j)) j = fail[j-1];
				if(s.charAt(i) == s.charAt(j)) fail[i] = ++j;
				cnt = Math.max(cnt, fail[i]);
				if(fail[i]==0)zero++;
			}

			if(cnt==0 || n%zero!=0) ans=1;
			else ans = n/(n-fail[n-1]);
			

			System.out.println(ans);
		}
	}
}