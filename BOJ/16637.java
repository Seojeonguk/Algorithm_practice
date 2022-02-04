import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static String s;
	static long ans=Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		
		s = br.readLine();
		
		solve(2,s.charAt(0)-'0');
		
		System.out.println(ans);

		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,long chk) {
		if(idx>=n) {
			ans = Math.max(ans, chk);
			return;
		}
		char c = s.charAt(idx-1);
		int t = s.charAt(idx)-'0';
		if(c=='+') solve(idx+2,chk+t);
		else if(c=='-') solve(idx+2,chk-t);
		else if(c=='*') solve(idx+2,chk*t);
		
		if(idx+1 < n) {
			char nc = s.charAt(idx+1);
			int nt = s.charAt(idx+2)-'0';
			
			int nnt = 0;
			if(nc=='+') nnt = t + nt;
			else if(nc=='-') nnt = t-nt;
			else if(nc=='*') nnt = t*nt;
			if(idx+3 <=n) {
				if(c=='+') solve(idx+4,chk+nnt);
				else if(c=='-') solve(idx+4,chk-nnt);
				else if(c=='*') solve(idx+4,chk*nnt);
			}
		}
	}
}