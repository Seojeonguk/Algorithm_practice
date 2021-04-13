import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n;
	static char[][] map;
	static int[][] dist;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			dist = new int[n][n];
			
			for(int i=0;i<n;i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			dist[0][0] = 0;
			q.add(new int[] {0,0,0});
			
			while(!q.isEmpty()) {
				int[] outdata = q.poll();
				
				for(int i=0;i<4;i++) {
					int nx = outdata[0] + X[i];
					int ny = outdata[1] + Y[i];
					if(nx<0|| ny<0 || nx>n-1 || ny>n-1) continue;
					int ncnt = outdata[2] + (map[nx][ny]-'0');
					if(ncnt < dist[nx][ny]) {
						dist[nx][ny] = ncnt;
						q.add(new int[] {nx,ny,ncnt});
					}
				}
			}
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(dist[n-1][n-1]) + "\n");
		}
		bw.flush();
		bw.close();
	}
}