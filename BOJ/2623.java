import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,k,x,prev_x;
	static int[] dist;
	static List<Integer> l[];
	static Queue<Integer> q,ans;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<Integer>();
		ans = new LinkedList<Integer>();
		l = new List[n+1];
		dist = new int[n+1];
		
		for(int i=0;i<=n;i++)
			l[i] = new LinkedList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<k;j++) {
				prev_x = x;
				x = Integer.parseInt(st.nextToken());
				if(j>0) {
					l[prev_x].add(x);
					dist[x]++;
				}
			}
		}
		
		for(int i=1;i<=n;i++)
			if(dist[i]==0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int data = q.poll();
			ans.add(data);
			
			int size = l[data].size();
			for(int i=0;i<size;i++) {
				int next = l[data].get(i);
				dist[next]--;
				if(dist[next]==0)
					q.add(next);
			}
		}
		
		if(ans.size()==n) {
			while(!ans.isEmpty()) {
				sb.append(ans.poll() + "\n");
			}
		} else sb.append("0");
		
		bw.write(sb.toString());
		bw.flush();
	}
} 