import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n,m,ans;
	static int[] dp;
	static Vector<Integer> v[];
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		v = new Vector[n+1];
		visit = new boolean[n+1];
		
		for(int i=0;i<n+1;i++) 
			v[i] = new Vector<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v[a].add(b);
			v[b].add(a);
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				bfs(i);
				ans++;
			}
		}
		
		bw.write(String.valueOf(ans));
		
		
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int index) throws Exception {
		Queue<Integer> q = new LinkedList<>();
		visit[index]  = true;
		q.add(index);
		
		while(!q.isEmpty()) {
			int outdata = q.poll();
			
			for(int next : v[outdata]) {
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
				}
			}
		}
		
	}
}