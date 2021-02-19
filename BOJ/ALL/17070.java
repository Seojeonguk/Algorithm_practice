import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,ans;
	static int[][] arr;
	static int X[]= {0,1,1},Y[]= {1,0,1};
	// 가로 세로 대각선
	
	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				arr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		solve(0,1,0);
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int x,int y,int d) {
		if(x==n-1 && y==n-1) {
			ans++;
			return;
		}
		int nx=0;
		int ny=0;
		// 가로
		if(d==0 || d==2) {
			nx = x + X[0];
			ny = y + Y[0];
			if(!range(nx,ny)) solve(nx,ny,0);
		}
		
		//세로
		if(d==1 || d==2) {
			nx = x + X[1];
			ny = y + Y[1];
			if(!range(nx,ny)) solve(nx,ny,1);
		}
		
		//대각선
		nx = x+X[2];
		ny = y+Y[2];
		if(!range(nx,ny) && arr[nx-1][ny]!=1 && arr[nx][ny-1]!=1) {
			solve(nx,ny,2);
		}
	}
	
	public static boolean range(int x,int y) {
		if(x<0 || y<0 || x>n-1 || y>n-1 || arr[x][y]==1) return true;
		return false;
	}
}