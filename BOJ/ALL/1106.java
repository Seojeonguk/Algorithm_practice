import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int c,n;
	static int[] cost,cnt;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		cost = new int[n];
		cnt = new int[n];
		
		dp = new int[n+1][1001];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n+1;i++)
			Arrays.fill(dp[i], -1);
		
		System.out.println(solve(0,c));
	}
	
	public static int solve(int idx,int sum) {
		if(dp[idx][sum] != -1 ) return dp[idx][sum];
		if(idx==n) return dp[idx][sum] = (sum !=0 ? 1000000000 : 0);
		
		dp[idx][sum] = solve(idx+1,sum);
		if(sum > 0)
			dp[idx][sum] = Math.min(dp[idx][sum], solve(idx,Math.max(sum-cnt[idx], 0)) + cost[idx]);
		return dp[idx][sum];
	}
}