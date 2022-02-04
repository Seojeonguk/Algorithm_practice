import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,d,f,t,c;
	static int[] dist;
	static List<int[]> l[];
	static Queue<int[]> q;


	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		dist = new int[10002];
		Arrays.fill(dist, Integer.MAX_VALUE);
		l = new LinkedList[10002];
		for(int i=0;i<10002;i++)
			l[i] = new LinkedList<int[]>();
		q = new LinkedList<int[]>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			l[f].add(new int[] {t,c});
		}
		
		dist[0]=0;
		q.add(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			for(int i=0;i<l[outdata[0]].size();i++) {
				int next = l[outdata[0]].get(i)[0];
				int next_cost = l[outdata[0]].get(i)[1];
				if(outdata[1] + next_cost < dist[next]) {
					dist[next] = outdata[1] + next_cost;
					q.add(new int[] {next,outdata[1]+next_cost});
				}
			}
			if(outdata[0]+1 < 10002 && outdata[1] + 1 < dist[outdata[0]+1]) {
				dist[outdata[0]+1] = outdata[1]+1;
				q.add(new int[] {outdata[0]+1,outdata[1]+1});
			}
		}
		sb.append(dist[d]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}