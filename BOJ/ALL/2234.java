import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,cnt,max_cnt,one_break_max_cnt;
	static int[][] block;
	static int[][] visit;
	static int[] arr; 
	static int X[]= {0,-1,0,1},Y[]= {-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		block = new int[51][51];
		visit = new int[51][51];
		arr = new int [51*51];
		
		st = new StringTokenizer(br.readLine());
		m = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				block[i][j] = Integer.valueOf(st.nextToken());
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(visit[i][j] == 0) 
					solve(i,j);
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				for(int k=0;k<4;k++)
					if(range(i+X[k],j+Y[k]) && visit[i][j] != visit[i+X[k]][j+Y[k]])
						one_break_max_cnt = Math.max(one_break_max_cnt, arr[visit[i][j]] + arr[visit[i+X[k]][j+Y[k]]]);
		
		bw.write(String.valueOf(cnt) + "\n" + String.valueOf(max_cnt) + "\n" + String.valueOf(one_break_max_cnt));
		bw.newLine();
					
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int x,int y) {
		int ret = 1;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		visit[x][y] = ++cnt;
		
		while(!q.isEmpty()) {
			Point outdata = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = outdata.x + X[i];
				int ny = outdata.y + Y[i];
				
				if(range(nx,ny) && (block[outdata.x][outdata.y] & (1<<i)) == 0 && visit[nx][ny] ==0) {
					visit[nx][ny] = cnt;
					ret++;
					q.add(new Point(nx,ny));
					
				}
			}
		}
		max_cnt = Math.max(max_cnt, ret);
		arr[cnt] = ret;
	}
	
	public static boolean range(int x,int y) {
		if(x<0 || y<0 || x>n-1 || y>m-1) return false;
		return true;
	}
}

class Point{
	int x,y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}