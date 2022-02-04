import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,b,w;
	static char[][] battlefield;
	static boolean[][] visit;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		battlefield = new char[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			battlefield[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j] == false) {
					solve(i,j);
				}
			}
		}
		
		sb.append(w + " " + b);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int x,int y) {
		int cnt=0;
		visit[x][y] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			cnt++;
			
			for(int i=0;i<4;i++) {
				int nx = outdata[0] + X[i];
				int ny = outdata[1] + Y[i];
				
				if(nx < 0 || ny<0 || nx>n-1 || ny>m-1 || visit[nx][ny] || battlefield[x][y] != battlefield[nx][ny]) 
					continue;
				
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}
		
		if(battlefield[x][y] == 'B') {  
			b += cnt * cnt;
		} else {
			w += cnt * cnt;
		}
		
	}
}