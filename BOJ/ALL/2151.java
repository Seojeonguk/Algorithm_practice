import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,sx=-1,sy,dx,dy;
	static char[][] map;
	static boolean[][][] visit;
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->o1[3]-o2[3]);
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};


	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				if(map[i][j] == '#') {
					if(sx==-1) {
						sx = i;
						sy = j;
					} else {
						dx = i;
						dy = j;
					}
				}
			}
		}
		
		visit = new boolean[n][n][4];
		
		for(int i=0;i<4;i++) {
			visit[sx][sy][i] = true;
			pq.add(new int[] {sx,sy,i,0});
		}
		
		while(!pq.isEmpty()) {
			int[] outdata = pq.poll();
			
			if(outdata[0] == dx && outdata[1] == dy) {
				sb.append(outdata[3]);
				break;
			}
			
			int nx = outdata[0] + X[outdata[2]];
			int ny = outdata[1] + Y[outdata[2]];
			if(nx<0 || ny<0 || nx>n-1 || ny>n-1 || visit[nx][ny][outdata[2]] || map[nx][ny]=='*') continue;
			visit[nx][ny][outdata[2]] = true;
			pq.add(new int[] {nx,ny,outdata[2],outdata[3]});
			if(map[nx][ny]=='!') {
				pq.add(new int[] {nx,ny,(outdata[2]+3)%4,outdata[3]+1});
				pq.add(new int[] {nx,ny,(outdata[2]+1)%4,outdata[3]+1});
			}
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}