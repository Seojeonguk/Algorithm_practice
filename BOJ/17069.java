import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,ans;
	static int[][] arr;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		arr = new int[n+1][n+1];
		dp = new long[n+1][n+1][3];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++)
				arr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		
		dp[1][2][0] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=3;j<=n;j++) {
				if(arr[i][j]==0) {
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
					
					if(arr[i-1][j] != 1 && arr[i][j-1] != 1) {
						dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
					}
					
					dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][1];
				}
			}
		}
		
		System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}