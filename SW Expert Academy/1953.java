import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,m,r,c,time,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] X = {-1, 0, 1, 0},Y = {0, 1, 0, -1};
	
	static int[][] tun = {
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{1, 0, 1, 0},	
			{0, 1, 0, 1},	
			{1, 1, 0, 0},	
			{0, 1, 1, 0},	
			{0, 0, 1, 1},	
			{1, 0, 0, 1},	
	};
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			
			ans=0;
			map = new int[n][m];
			visit = new boolean[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Queue<int[]> q = new LinkedList<int[]>(); 
			visit[r][c] = true;
			q.add(new int[] {r,c,1});
			
			while(!q.isEmpty()) {
				int[] outdata = q.poll();
				
				ans++;
				if(outdata[2] == time) continue;
				
				int[] dirs = tun[map[outdata[0]][outdata[1]]];
				for (int dir = 0; dir < dirs.length; dir++) {
					if (dirs[dir] == 0) continue;
					int nx = outdata[0] + X[dir];
					int ny = outdata[1] + Y[dir];
					if (nx < 0 || ny < 0 || nx > n-1 || ny > m-1 || map[nx][ny]==0 || visit[nx][ny]) continue;	// 범위 체크
					if (tun[map[nx][ny]][(dir + 2) % 4] == 1) { 	
						visit[nx][ny] = true;
						q.offer(new int[] {nx, ny,outdata[2]+1});
					}
				}
				
			}
			
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(ans) + "\n");
		}
		bw.flush();
		bw.close();
	}
}