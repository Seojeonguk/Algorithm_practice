import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,k,ans;
	static int[] kit;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		kit = new int[n];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			kit[i] = Integer.parseInt(st.nextToken());
		
		solve(0,500);
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int cnt,int sum) {
		if(sum<500) return;
		if(cnt==n) {
			ans++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				solve(cnt+1,sum-k+kit[i]);
				visit[i] = false;
			}
		}
	}
}