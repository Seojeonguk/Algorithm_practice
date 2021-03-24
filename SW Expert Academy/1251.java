import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class data {
		int idx1,idx2;
		long cost;
		public data(int idx1,int idx2, long cost) {
			this.idx1 = idx1;
			this.idx2 = idx2;
			this.cost = cost;
		}
	}
	
	static int t,n;
	static int[] x,y;
	static double e;
	static long ans;
	static int[] p,rank;
	static PriorityQueue<data> pq;
	
	public static void main(String[] args) throws Exception {
		t = Integer.valueOf(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			n = Integer.valueOf(br.readLine());
			
			pq = new PriorityQueue<data>((o1,o2) -> Long.compare(o1.cost, o2.cost));
			ans=0;
			x = new int[n];
			y = new int[n];
			p = new int[n];
			rank = new int[n];
			for(int i=0;i<n;i++)
				p[i] = i;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) x[i] = Integer.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) y[i] = Integer.valueOf(st.nextToken());
			
			e = Double.valueOf(br.readLine());
			
			for(int i=0;i<n;i++) 
				for(int j=i+1;j<n;j++) {
					long x_dis = Math.abs(x[i]-x[j]);
					x_dis *= x_dis;
					long y_dis = Math.abs(y[i]-y[j]);
					y_dis *= y_dis;
					pq.add(new data(i,j,x_dis+y_dis));
				}
					
			
			while(!pq.isEmpty()) {
				data outdata = pq.poll();
				
				if(find(outdata.idx1) != find(outdata.idx2)) {
					merge(outdata.idx1,outdata.idx2);
					ans += outdata.cost;
				}
			}
			bw.write("#" + String.valueOf(tc) + " " + Math.round(ans*e) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int find(int u) {
        if(u==p[u]) return u;
        return p[u] = find(p[u]);
    }
     
    public static void merge(int u,int v) {
        u = find(u);
        v = find(v);
        if(u==v) return;
        if(rank[u]>rank[v])
            p[v]=u;
        else {
            p[u]=v;
            if(rank[u]==rank[v])
                rank[v]++;
        }
    }
}