import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int n,m;
	static int[] w;
	static boolean[][] visit;
	
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		w = new int[n];
		visit = new boolean[n+1][15001];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			w[i] = Integer.parseInt(st.nextToken());
		
		dfs(0,0);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<m;i++) {
			int weight = Integer.parseInt(st.nextToken());
			
			if(weight>15000) sb.append("N ");
			else {
				if(visit[n][weight]) sb.append("Y ");
				else sb.append("N ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int cnt,int sum) {
		if(visit[cnt][sum]) return;
		visit[cnt][sum] = true;
		if(cnt==n) return;
		
		dfs(cnt+1,sum+w[cnt]);
		dfs(cnt+1,sum);
		dfs(cnt+1,Math.abs(sum-w[cnt]));
	}
}