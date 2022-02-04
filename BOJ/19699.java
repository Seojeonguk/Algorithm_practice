import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m;
	static int[] h;
	static boolean[] chk;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chk = new boolean[n*1000+4];
		for(int i=2;i<n*1000+4;i++) {
			if(!chk[i]) {
				for(int j=i+i;j<n*1000+4;j+=i)
					chk[j] = true;
			}
		}
		
		h = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			h[i] = Integer.parseInt(st.nextToken());
		
		solve(0,0,0);
		if(pq.isEmpty()) sb.append("-1");
		
		while(!pq.isEmpty())
			sb.append(pq.poll()+" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int idx,int cnt,int sum) {
		if(cnt==m) {
			if(!chk[sum]) {
				chk[sum] = true;
				pq.add(sum);
			}
			return;
		}
		if(idx==n) return;
		
		
		solve(idx+1,cnt+1,sum+h[idx]);
		solve(idx+1,cnt,sum);
	}
}