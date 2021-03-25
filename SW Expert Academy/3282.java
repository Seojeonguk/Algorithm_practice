import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,k,v,c;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		t = Integer.valueOf(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			k = Integer.valueOf(st.nextToken());
			
			dp = new int [k+1];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				v = Integer.valueOf(st.nextToken());
				c = Integer.valueOf(st.nextToken());
				
				for(int j=k;j>=v;j--)
					dp[j] = Math.max(dp[j], c+dp[j-v]);
			}
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(dp[k]) + "\n");
		}
		bw.flush();
		bw.close();
	}
}