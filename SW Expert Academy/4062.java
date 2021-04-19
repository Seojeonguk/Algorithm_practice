import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t,n,ans;
	static int[][] dp;
	static char[][] map;
	static char[] temp;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n+1][n+1];
			dp = new int[n+1][n+1];
			ans =0;
			
			for(int i=1;i<=n;i++) {
				temp = br.readLine().toCharArray();
				for(int j=1;j<=n;j++)
					map[i][j] = temp[j-1];
			}
			
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++) {
					if(map[i][j]=='1') dp[i][j]=0;
					else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
					ans = Math.max(ans,dp[i][j]);
				}
				
			
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}