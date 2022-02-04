import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	static char[][] map;
	static boolean[][] visit;
	static int n=12,m=6,ans;
	
	public static void main(String[] args) throws Exception {
		map = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) 
			map[i] = br.readLine().toCharArray();
		
		while(true) {
			boolean destroy = false;
			for(int i=0;i<n;i++)
				Arrays.fill(visit[i], false);
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] !='.' && !visit[i][j]) {
						Queue<int[]> q = new LinkedList<int[]>();
						List<int[]> l = new LinkedList<int[]>();
						
						q.add(new int[] {i,j});
						visit[i][j] = true;
						while(!q.isEmpty()) {
							int[] outdata = q.poll();
							
							l.add(outdata);
							
							for(int k=0;k<4;k++) {
								int nx = outdata[0] + X[k];
								int ny = outdata[1] + Y[k];
								
								if(nx<0 || ny<0 || nx>n-1 || ny>m-1 || map[outdata[0]][outdata[1]] != map[nx][ny] ||visit[nx][ny]) continue;
								q.add(new int[] {nx,ny});
								visit[nx][ny] = true;
							}
						}
						
						if(l.size() >= 4) {
							destroy = true;
							for(int[] item : l) {
								map[item[0]][item[1]] = '.';
							}
						}
					}
				}
			}
			
			
			for (int i = 0; i < 6; i++) {
	            int now = n - 1;
	            for (int j = n - 1; j >= 0; j--) {
	                if (map[j][i] != '.') {
	                	char temp = map[now][i];
	                	map[now--][i] = map[j][i];
	                	map[j][i] = temp;
	                }
	            }
	        }
			if(!destroy) break;
			ans++;
		}
		System.out.println(ans);
	}
}