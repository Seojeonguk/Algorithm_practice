import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,res;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	static int[][] s;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		s = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				s[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(res=0; !done();res++)
			solve(0,0);
				
		System.out.println(res);
	}
	
	public static boolean done() {
		int cnt=0;
		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++)
				if(s[i][j]==-1 || s[i][j]>2)
					s[i][j] =0;
				else if(s[i][j]==1 || s[i][j] ==2) {
					s[i][j] = 1;
					cnt++;
				}
		return cnt==0;
	}
	
	public static void solve(int x,int y) {
		s[x][y] = -1;
		for(int i=0;i<4;i++) {
			int nx = x + X[i];
			int ny = y + Y[i];
			if(nx<0 || ny<0 || nx>n-1 || ny>m-1) continue;
			if(s[nx][ny] == 0)
				solve(nx,ny);
			else if(s[nx][ny] > 0)
				s[nx][ny]++;
		}
	}
}