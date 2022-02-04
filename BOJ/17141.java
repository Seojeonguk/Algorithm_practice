import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,ans=Integer.MAX_VALUE,virus_cnt;
	static boolean[] choice;
	static int[][] map;
	static boolean[][] visit;
	static List<int[]> l;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][n];
		l = new LinkedList<int[]>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					map[i][j] =0;
					l.add(new int[] {i,j});
				}
			}
		}
		virus_cnt = l.size();
		choice = new boolean[virus_cnt];
		solve(0,0);
		
		
		if(ans==Integer.MAX_VALUE) ans = -1;
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int idx,int cnt) {
		if(cnt==m) {
			int temp = 0;
			visit = new boolean[n][n];
			Queue<int[]> q = new LinkedList<int[]>();
			for(int i=0;i<virus_cnt;i++) {
				if(choice[i]) {
					visit[l.get(i)[0]][l.get(i)[1]] = true;
					q.add(new int[] {l.get(i)[0],l.get(i)[1],0});
				}
			}
			
			while(!q.isEmpty()) {
				int[] outdata = q.poll();
				temp = Math.max(temp, outdata[2]);
				
				for(int i=0;i<4;i++) {
					int nx = outdata[0] + X[i];
					int ny = outdata[1] + Y[i];
					if(nx<0 || ny<0 || nx>n-1 || ny>n-1 || visit[nx][ny] || map[nx][ny] == 1) continue;
					visit[nx][ny] = true;
					q.add(new int[] {nx,ny,outdata[2]+1});
				}
			}
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(map[i][j]==0 && !visit[i][j])
						temp = Integer.MAX_VALUE;
			
			ans = Math.min(ans, temp);
			
			return;
		}
		if(idx==virus_cnt) return;
		
		
		solve(idx+1,cnt);
		choice[idx] = true;
		solve(idx+1,cnt+1);
		choice[idx] = false;
	}
}