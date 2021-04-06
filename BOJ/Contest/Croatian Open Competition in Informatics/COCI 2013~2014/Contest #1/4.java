import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class gem implements Comparable<gem> {
		int m,v;
		public gem(int m,int v) {
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(gem o) {
			return Integer.compare(this.m, o.m);
		}
	}

	static int n,k;
	static long ans;
	static int[] bag;
	static gem[] gemlist;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->o2-o1);


	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		gemlist = new gem[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			gemlist[i] = new gem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}

		bag = new int[k];
		for(int i=0;i<k;i++) 
			bag[i]=Integer.parseInt(br.readLine());
		
		Arrays.sort(bag);
		Arrays.sort(gemlist);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		int idx = 0;
		for (int i = 0; i < k; i++) {
			while (idx < n && gemlist[idx].m <= bag[i]) {
				pq.add(gemlist[idx].v);
				idx++;
			}
			if (!pq.isEmpty()) ans += pq.poll();
		}

		System.out.println(ans);
	}
}