import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static HashSet<Integer> s = new HashSet<Integer>();
	static int n=5;
	static int[][] map;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				solve(i,j,1,map[i][j]);
		
		sb.append(s.size());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int x,int y,int cnt,int sum) {
		if(cnt==6) {
			s.add(sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+X[i];
			int ny = y+Y[i];
			if(nx<0|| ny<0 || nx>n-1 || ny>n-1) continue;
			solve(nx,ny,cnt+1,sum*10+map[nx][ny]);
		}
	}
}