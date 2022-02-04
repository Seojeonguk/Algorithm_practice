import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int k,ans,s;
	static int[] g;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		k = Integer.parseInt(br.readLine());
		g = new int[k];
		visit = new boolean[200000*k+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			g[i] = Integer.parseInt(st.nextToken());
			s+= g[i];
		}
		
		solve(0,0);
		
		for(int i=1;i<=s;i++)
			if(!visit[i])
				ans++;
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int idx,int sum) {
		visit[sum] = true;
		if(idx==k) return;
		solve(idx+1,sum+g[idx]);
		solve(idx+1,sum);
		solve(idx+1,Math.abs(sum-g[idx]));
	}
}