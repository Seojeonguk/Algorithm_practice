import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,ans;
	static Point[] l;
	static PriorityQueue<Integer> pq;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		pq = new PriorityQueue<Integer>();
		l = new Point[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int t = Integer.valueOf(st.nextToken());
			l[i] = new Point(s,t);
		}
		
		Arrays.sort(l);

		for(int i=0;i<n;i++) {
			if(pq.isEmpty()) pq.add(l[i].t);
			else {
				while(!pq.isEmpty() && pq.peek()<=l[i].s) {
					pq.poll();
				}
				pq.add(l[i].t);
			}
			ans = Math.max(ans, pq.size());
		}
		
		bw.write(String.valueOf(ans));

		bw.flush();
		bw.close();
	}
}

class Point implements Comparable<Point> {
	int s,t;
	public Point(int s,int t) {
		this.s = s;
		this.t = t;
	}
	@Override
	public int compareTo(Point o) {
		return this.s-o.s;
	}
}