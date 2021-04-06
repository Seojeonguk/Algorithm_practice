import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m;
	static int from,to,cost,max,min;
	static int[] p;
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2) -> o1[2]-o2[2]);
	static PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>((o1,o2) -> o2[2]-o1[2]);
	
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		
		for(int i=0;i<m+1;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			pq.add(new int[] {from,to,cost});
			pq2.add(new int[] {from,to,cost});
		}
		
		for(int i=0;i<=n;i++)
			p[i] = i;
		
		while(!pq.isEmpty()) {
			int[] outdata = pq.poll();
			
			if(find(outdata[0]) != find(outdata[1])) {
				merget(outdata[0],outdata[1]);
				max += (outdata[2]+1)%2;
			}
		}
		
		for(int i=0;i<=n;i++)
			p[i] = i;
		
		while(!pq2.isEmpty()) {
			int[] outdata = pq2.poll();
			
			if(find(outdata[0]) != find(outdata[1])) {
				merget(outdata[0],outdata[1]);
				min += (outdata[2]+1)%2;
			}
		}
		sb.append((max*max-min*min));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	public static void merget(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y) return;
		p[x] = y;
	} 
}