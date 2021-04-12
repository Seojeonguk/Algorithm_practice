import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class data implements Comparable<data> {
		int s,e;
		public data(int s,int e) {
			this.s=s;
			this.e=e;
		}
		
		@Override
		public int compareTo(data o) {
			if(this.s == o.s) return this.e-o.e;
			return this.s-o.s;
		}
	}

	static int n,ans;
	static data[] d;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		d = new data[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			d[i] = new data(s,e);
		}
		
		Arrays.sort(d);

		for(int i=0;i<n;i++) {
			if(pq.isEmpty()) {
				pq.add(d[i].e);
			} else {
				while(!pq.isEmpty()) {
					if(pq.peek() <= d[i].s) pq.poll(); 
					else break;
				}
				pq.add(d[i].e);
			}
			ans = Math.max(ans, pq.size());
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}