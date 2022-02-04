import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class data{
		int x,y,cnt,horse;
		public data(int x,int y,int cnt,int horse) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.horse = horse;
		}
	}

	static int k,n,m;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<data> q = new LinkedList<data>();
	static int X[] = { 1, 0, -1, 0 },Y[] = { 0, 1, 0, -1 };
	static int horseX[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int horseY[] = { 2, 1, -1, -2, -2, -1, 1, 2 };


	public static void main(String[] args) throws Exception {
		k = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		m = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][k+1];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				map[i][j] = Integer.valueOf(st.nextToken());
		}

		int ans=-1;
		q.add(new data(0,0,0,k));
		visit[0][0][k] = true;

		while(!q.isEmpty()) {
			data outdata = q.poll();

			if(outdata.x == n-1 && outdata.y == m-1) {
				ans = outdata.cnt;
				break;
			}

			int nx=0,ny=0,ncnt=outdata.cnt+1,nhorse=outdata.horse;
			for(int i=0;i<4;i++) {
				nx = outdata.x + X[i];
				ny = outdata.y + Y[i];

				if(nx<0 || ny<0 || nx>n-1 || ny>m-1) continue;
				if(map[nx][ny] == 1 || visit[nx][ny][nhorse]) continue;
				visit[nx][ny][nhorse] = true;
				q.add(new data(nx,ny,ncnt,nhorse));
			}

			if(nhorse>0) {
				nhorse--;
				for(int i=0;i<8;i++) {
					nx = outdata.x + horseX[i];
					ny = outdata.y + horseY[i];
					if(nx<0 || ny<0 || nx>n-1 || ny>m-1) continue;
					if(map[nx][ny] == 1 || visit[nx][ny][nhorse]) continue;
					visit[nx][ny][nhorse] = true;
					q.add(new data(nx,ny,ncnt,nhorse));
				}
			}
		}

		System.out.println(ans);
	}
}
