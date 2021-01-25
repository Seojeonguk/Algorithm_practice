import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n,m;
	static boolean[] visit;
	static Vector<Integer>[] v;
	static boolean chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		v = new Vector[n];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++)
			v[i] = new Vector<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v[a].add(b);
			v[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			visit[i] = true;
			solve(i,0);
			visit[i] = false;
		}
		
		bw.write(String.valueOf(chk?"1":"0"));
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int now,int cnt) {
		if(chk) return;
		if(cnt==4) {
			chk = true;
			return;
		}
		for(int x : v[now]) {
			if(visit[x] == false) {
				visit[x] = true;
				solve(x,cnt+1);
				visit[x] = false;
			}
		}
	}
}