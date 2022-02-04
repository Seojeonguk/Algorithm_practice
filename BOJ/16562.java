import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,k,ans;
	static int[] p,cost;
	static Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	static boolean[] visit;
	
	
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		cost = new int[n+1];
		visit = new boolean[n+1];
		
		for(int i=1;i<=n;i++)
			p[i] = i;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++)
			cost[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1;i<=n;i++) {
			int next = find(p[i]);
			if(!visit[next]) {
				visit[next] = true;
				ans += cost[next];
			}
		}
		
		if(ans <= k) sb.append(ans);
		else sb.append("Oh no");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	public static void merge(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y) return;
		if(cost[x] > cost[y]) p[x] = y;
		else p[y] = x;
	} 
}