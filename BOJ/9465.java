import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int t,n;
	static int[][] arr,dp;

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[2][n+1];
			dp = new int[2][n+1];
			
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int i=2;i<=n;i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}