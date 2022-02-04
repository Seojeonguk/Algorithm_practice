import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m;
	static char[][] map;
	static int[][] visit;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	static boolean chk;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visit = new int[n][m];
		
		for(int i=0;i<n;i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(visit[i][j]==0 && !chk)
					solve(i,j,1);
		
		if(chk) sb.append("Yes");
		else sb.append("No");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int x,int y,int cnt) {
		if(chk) return;
		visit[x][y] = cnt;
		
		for(int i=0;i<4;i++) {
			int nx = x + X[i];
			int ny = y + Y[i];
			if(nx<0|| ny<0||nx>n-1 || ny>m-1 || map[x][y] != map[nx][ny]) continue;
			if(visit[nx][ny]!=0) {
				if(visit[nx][ny]+1 != visit[x][y]) {
					chk = true;
					return;
				}
			} else 
				solve(nx,ny,cnt+1);
			
		}
	}
}