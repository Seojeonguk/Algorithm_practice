import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,ans;
	static int[][] f;
	
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			ans=Integer.MAX_VALUE;
			f = new int[n][n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++) {
					f[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && f[i][j]==0) f[i][j]=99999999;
				}
			
			for(int k=0;k<n;k++)
				for(int i=0;i<n;i++) { 
					if(f[i][k]==99999999) continue;
					for(int j=0;j<n;j++)
						f[i][j] = Math.min(f[i][j], f[i][k]+f[k][j]);
				}
			
			
			for(int i=0;i<n;i++) {
				int sum=0;
				for(int j=0;j<n;j++)
					sum+= f[i][j];
				ans = Math.min(ans, sum);
			}
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(ans) + "\n");
		}
		bw.flush();
		bw.close();
	}
}