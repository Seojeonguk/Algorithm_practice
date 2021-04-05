import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class info {
		int start,end,weight;
		
		public info(int start,int end,int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int n,m,cnt,ans;
	static char[] uni;
	static PriorityQueue<info> pq = new PriorityQueue<info>((o1,o2)->o1.weight-o2.weight);
	static int[] par;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		uni = new char[n+1];
		par = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) 
			uni[i] = st.nextToken().charAt(0);
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		for(int i=1;i<=n;i++)
			par[i] = i;
		
		while(!pq.isEmpty()) {
			info outdata = pq.poll();
			
			if(find(outdata.start) != find(outdata.end)) {
				if(uni[outdata.start]!= uni[outdata.end]) {
					cnt++;
					ans += outdata.weight;
					union(outdata.start, outdata.end);
				}
			}
		}
		sb.append((cnt!=n-1 ? -1 : ans));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int find(int x) {
		if(x==par[x]) return x;
		return par[x] = find(par[x]);
	}
	
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y) return;
		par[y] = x;
	}
}