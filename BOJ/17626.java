import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int [n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i=1;i*i<=n;i++)
			dp[i*i] = 1;
		
		for(int i=1;i<=n;i++) {
			if(dp[i] == Integer.MAX_VALUE) {
				int sqrt = (int)Math.sqrt(i);
				for(int j=sqrt;j>=1;j--) {
					dp[i]  = Math.min(dp[i], dp[j*j] + dp[i-j*j]);
				}
			}
		}
		
		sb.append(dp[n]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}