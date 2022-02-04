import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,m;
	static int[][]cost;
	static int[][]ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		cost = new int[n+1][n+1];
		ans = new int[n+1][n+1];

		for(int i=1;i<=n;i++) {
			Arrays.fill(cost[i], 99999999);
			cost[i][i] = 0;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			cost[a][b] = cost[b][a] = c;
			ans[a][b] = b;
			ans[b][a] = a;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(k==i) continue;
				for(int j=1;j<=n;j++) {
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
						ans[i][j] = ans[i][k];
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) bw.write("-");
				else bw.write(String.valueOf(ans[i][j]));
				bw.write(" ");
			}
			bw.newLine();
		}
		
		
		bw.flush();
		bw.close();
	}
}