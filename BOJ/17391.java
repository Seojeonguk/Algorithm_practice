import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m;
	static int[][] map;
	static int[] X= {1,0},Y= {0,1};
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		q.add(new int[] {0,0,0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			if(outdata[0] == n-1 && outdata[1] == m-1) {
				sb.append(outdata[2]);
				break;
			}
			
			for(int i=0;i<2;i++) {
				for(int j=map[outdata[0]][outdata[1]] ; j>0;j--) {
					int nx = outdata[0] + X[i] * j;
					int ny = outdata[1] + Y[i] * j;
					if(nx<0 || ny<0  || nx>n-1 || ny>m-1 || visit[nx][ny]) continue;
					visit[nx][ny] = true;
					q.add(new int[] {nx,ny,outdata[2]+1});
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}