import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		dp = new int[n+1][3];
		arr = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++)
				arr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<3;i++)
			ans = Math.min(ans, dp[n][i]);
		System.out.println(ans);
	}
}
