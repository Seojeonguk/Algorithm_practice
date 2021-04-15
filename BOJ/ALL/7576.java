import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m,ans,empty_cnt;
	static int[][] map;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) 
					empty_cnt++;
				if(map[i][j] == 1) 
					q.add(new int[] {i,j,0});
			}
		}
		
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			
			ans = Math.max(ans, outdata[2]);
			
			for(int i=0;i<4;i++) {
				int nx = outdata[0] + X[i];
				int ny = outdata[1] + Y[i];
				if(nx<0 || ny<0 || nx>n-1 || ny>m-1 || map[nx][ny]!=0) continue;
				map[nx][ny] = 1;
				q.add(new int[] {nx,ny,outdata[2]+1});
				empty_cnt--;
			}
		}
		
		if(empty_cnt!=0)ans=-1;
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}