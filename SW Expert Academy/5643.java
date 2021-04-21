import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t,n,m,ans;
	static boolean[][] chk;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			chk = new boolean[n+1][n+1];
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				chk[x][y] = true;
			}
			
			for(int k=1;k<=n;k++) 
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (!chk[i][k]) break;
						chk[i][j] |= (i == j ? true : (chk[i][k] & chk[k][j]));
					}
				}

			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					chk[j][i] |= chk[i][j];

			ans = n;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++)
					if (i!=j && !chk[i][j]) {
						ans--;
						break;
					}
			}
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}