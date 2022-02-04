import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m,a,b,ans;
	static int[] p;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		for(int i=1;i<=n;i++)
			p[i] = i;
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(find(a) != find(b)) merge(a,b);
			else {
				ans = i;
				break;
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	public static void merge(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y) return;
		p[x] = y;
	}
}