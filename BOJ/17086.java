import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] X= {1,0,-1,0,1,1,-1,-1},Y= {0,1,0,-1,1,-1,1,-1};
	
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					visit[i][j] = true;
					q.add(new int[] {i,j,0});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			ans = Math.max(ans,outdata[2]);
			
			for(int i=0;i<8;i++) {
				int nx = outdata[0]+X[i];
				int ny = outdata[1] + Y[i];
				int ncnt = outdata[2]+1;
				
				if(nx<0 || ny<0 || nx>n-1 || ny>m-1 || visit[nx][ny]) continue;
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny,ncnt});
			}
		}
		
		System.out.println(ans);
	}
}