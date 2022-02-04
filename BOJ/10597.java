import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static String s;
	static int[] visit;
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		visit = new int[60];
		
		s = br.readLine();
		
		if(s.length()<=9)n=s.length();
		else n = 9 + (s.length()-9)/2;
		
		ans = new int[s.length()];
		
		solve(0,0);
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,int c) {
		if(idx==s.length()) {
			for(int i=1;i<=n;i++)
				if(visit[i]!=1) 
					return;
			for(int i=0;i<c;i++) {
				System.out.print(ans[i] + " " );
			}
			System.out.println();
			System.exit(0);
		}
		int now = s.charAt(idx)-'0';
		
		if(now!=0 && visit[now]==0) {
			ans[c] = now;
			visit[now]++;
			solve(idx+1,c+1);
			visit[now]--;
			ans[c]=0;
		}
		
		if(idx+1 != s.length()) {
			now = now *10 + s.charAt(idx+1)-'0';
			if(n>=now && visit[now]==0) {
				ans[c] = now;
				visit[now]++;
				solve(idx+2,c+1);
				visit[now]--;
				ans[c] = 0;
			}
		}
	}
}