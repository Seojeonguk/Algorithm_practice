import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,cnt;
	static char[][] arr;
	static boolean[][] visit;
	static boolean last;
	static int X[]= {-1,0,1},Y[]= {1,1,1};
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m =Integer.valueOf(st.nextToken());
		
		arr = new char[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			if(arr[i][0]=='.' && !last)  {
				visit[i][0] = true;
				cnt+=solve(i,0,0);
			}
				
		}
		
		System.out.println(cnt);
		
		bw.flush();
		bw.close();
	}
	
	public static int solve(int x,int y,int cnt) {
		int chk = 0;
		if(y==m-1) return 1;
		
		for(int i=0;i<3;i++) {
			int nx = x + X[i];
			int ny = y + Y[i];
			if(nx==n-1) last= true;
			if(nx<0 || nx>n-1 || visit[nx][ny] || arr[nx][ny]=='x') continue;
			visit[nx][ny] = true;
			chk = solve(nx,ny,cnt+1);
			if(chk==1) break;
		}
		return chk;
	}
}