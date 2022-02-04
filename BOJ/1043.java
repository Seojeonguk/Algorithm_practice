import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,cnt;
	static int[] p;
	static boolean[] visit;
	static int[][] tmp;



	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		tmp = new int[m][52];
		p = new int[n+1];
		for(int i=1;i<=n;i++)
			p[i] = i;
		visit = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());

		for(int i=0;i<cnt;i++) {
			int x = Integer.parseInt(st.nextToken());
			visit[x] = true;
		}

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			tmp[i][0] = Integer.parseInt(st.nextToken());
			for(int j=1;j<=tmp[i][0];j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
				merge(tmp[i][1],tmp[i][j]);
			}
		}
		
		int ans = m;
		for(int i=0;i<m;i++) {
			for(int j=1;j<=tmp[i][0];j++) {
				if(visit[find(tmp[i][j])]  ) {
					ans--;
					break;
				}
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
		if(visit[x]) p[y] = x;
		else p[x] = y;
	} 
}