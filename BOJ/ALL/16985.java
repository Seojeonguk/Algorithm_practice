import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int ans=Integer.MAX_VALUE;
	static int[][][] arr,ret,a;
	static boolean[][][] visit;
	static int[][] temp;
	static boolean[] chk;
	static int[] X= {1,0,-1,0,0,0},Y= {0,1,0,-1,0,0},Z= {0,0,0,0,1,-1};

	public static void main(String[] args) throws Exception {
		arr = new int[5][5][5];
		ret = new int[5][5][5];
		a = new int[5][5][5];
		temp = new int[5][5];
		chk = new boolean[5];
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<5;k++) 
					arr[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate(0,arr);
		
		if(ans==Integer.MAX_VALUE) ans = -1;
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void rotate(int z_idx,int[][][] map) {
		if(z_idx==5) {
			dfs(0,map);
			return;
		}

		for(int i=0;i<4;i++) {
			int copy_map[][][] = copy_rotate(z_idx,i,map);
			rotate(z_idx+1,copy_map);
		}
	}
	
	public static int[][][] copy_rotate(int idx,int cnt,int[][][] map) {
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				for(int k=0;k<5;k++)
					ret[i][j][k] = map[i][j][k];
		
		for(int a=0;a<cnt;a++) {
			
			for(int i=0;i<5;i++) 
				for(int j=0;j<5;j++) 
					temp[i][j] = ret[idx][i][j];
			
			for(int i=0;i<5;i++)
				for(int j=0;j<5;j++)
					ret[idx][j][4-i] = temp[i][j];
		}
		
		return ret;
	}
	
	public static void dfs(int cnt,int[][][] copy_map) {
		if(cnt==5) {
			solve(a);
			return;
		}
		
		for(int i=0;i<5;i++) {
			if(!chk[i]) {
				chk[i] = true;
				for(int b=0;b<5;b++)
					for(int c=0;c<5;c++)
						a[cnt][b][c] = copy_map[i][b][c];
				dfs(cnt+1,copy_map);
				chk[i] =false;
			}
		}
	}
	
	
	public static void solve(int[][][] map) {
		if(map[0][0][0] != 1 || map[4][4][4] != 1) 
			return;
		
		visit = new boolean[5][5][5];
		Queue<int[]> q = new LinkedList<int[]>();
		visit[0][0][0] = true;
		q.add(new int[] {0,0,0,0});
		
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			if(outdata[3] >= ans) return;
			
			if(outdata[0] == 4 && outdata[1] == 4 && outdata[2] == 4) {
				ans = Math.min(ans, outdata[3]);
				return;
			}
			
			for(int i=0;i<6;i++) {
				int nz = outdata[0] + Z[i];
				int nx = outdata[1] + X[i];
				int ny = outdata[2] + Y[i];
				
				if(nx<0 || ny<0 || nz<0 || nx>4 || ny>4 || nz>4 || visit[nz][nx][ny] || map[nz][nx][ny]==0) continue;
				visit[nz][nx][ny] = true;
				q.add(new int[] {nz,nx,ny,outdata[3]+1});
			}
		}
	}
} 