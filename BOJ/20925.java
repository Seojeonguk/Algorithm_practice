import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,t;
	static int[][] map,time,dp;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][2];
		time = new int[n+1][n+1];
		dp = new int[1001][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++)
				time[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < t; i++) {
	        for (int j = 1; j <= n; j++) {
	            if (dp[i][j] >= map[j][0]) dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + map[j][1]);
	            for (int k = 1; k <= n; k++) {
	                if (i + time[j][k] <= t && dp[i][j] >= map[k][0]) {
	                    dp[i + time[j][k]][k] = Math.max(dp[i + time[j][k]][k], dp[i][j]);
	                }
	            }
	        }
	    }
	    int ans = 0;
	    for (int i = 1; i <= n; i++) ans = Math.max(ans, dp[t][i]);
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}