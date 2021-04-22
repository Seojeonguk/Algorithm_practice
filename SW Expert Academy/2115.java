import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t,n,m,c,ans,max_value;
	static int[][] bee;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			bee = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
					bee[i][j] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,0,0);
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,int cnt, int sum) {
		if(cnt==2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=idx;i<n*n;i++) {
			int r = i%n;
			if(r+m-1<n) {
				max_value=0;
				calc(i,0,0,0);
				solve(i+m,cnt+1,sum+max_value);
			}
		}
	}
	
	public static void calc(int idx,int cnt,int sum,int value) {
		if(cnt == m) {
			max_value = Math.max(max_value, value);
			return;
		}
		
		int next_bee = bee[idx/n][idx%n];
		if(sum + next_bee <= c) 
			calc(idx+1,cnt+1,sum+next_bee,value + next_bee*next_bee);
		calc(idx+1,cnt+1,sum,value);
	}
}