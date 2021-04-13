import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,ans=Integer.MAX_VALUE;
	static int[] num;
	static List<Integer> l[];

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		l = new List[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = new LinkedList<Integer>();
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				int next_idx = Integer.parseInt(st.nextToken());
				l[i].add(next_idx);
			}
		}
		
		for(int i=0;i<(1<<n);i++) ans = Math.min(ans, solve(i));
		
		if(ans == Integer.MAX_VALUE) ans =-1;
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int solve(int idx) {
		boolean[] visit = new boolean[n+1];
		int chk=0;
		int b_sum=0,r_sum=0;
		for(int k=0;k<2;k++) {
			for(int i=1;i<=n;i++) {
				int n = Math.min(1, (1<<(i-1)) & idx);
				if(n==chk) {
					Queue<Integer> q = new LinkedList<Integer>();
					q.add(i);
					visit[i] = true;
					
					while(!q.isEmpty()) {
						int now = q.poll();
						
						if(chk==0) b_sum+=num[now];
						else if(chk==1) r_sum+=num[now];
						
						for(int next : l[now]) {
							int next_chk = Math.min(1, (1<<(next-1))&idx);
							if(next_chk == n && !visit[next]) {
								visit[next] = true;
								q.add(next);
							}
						}
					}
					chk++;
				}
			}
		}
		
		for(int i=1;i<=n;i++)
			if(!visit[i])
				return Integer.MAX_VALUE;
		
		return Math.abs(b_sum-r_sum);
	}
}