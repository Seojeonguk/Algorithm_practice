import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,m,ax,ay;
	static char[][] arr;
	static int[][] cnt;
	static char[] brr;
	static int X[]= {0,1,1,1,0,0,0,-1,-1,-1},Y[]= {0,-1,0,1,-1,0,1,-1,0,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		arr = new char[n][m];
		cnt = new int [n][m];

		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(arr[i][j] == 'R') cnt[i][j] = 1;
				if(arr[i][j] == 'I') {
					arr[i][j] = '.';
					ax = i;
					ay = j;
				}
			}
		}

		brr = br.readLine().toCharArray();

		for(int k=0;k<brr.length;k++) {
			ax += X[brr[k]-'0'];
			ay += Y[brr[k]-'0'];

			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j] == 'R') {
						int nx = i,ny = j;
						arr[i][j] = '.';
						cnt[i][j]--;
						if(ax < nx) nx--;
						else if(ax > nx) nx++;
						if(ay < ny) ny--;
						else if(ay > ny) ny++;
						if(nx == ax && ny == ay) {
							bw.write("kraj "+Integer.valueOf(k+1));
							bw.flush();
							bw.close();
							System.exit(0);
						}
						cnt[nx][ny]++;
					}
				}
			}

			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(cnt[i][j] > 1) {
						arr[i][j] = '.';
						cnt[i][j] = 0;
					}
					else if(cnt[i][j]==1) arr[i][j]='R';
				}
			}
		}

		arr[ax][ay] = 'I';

		for(int i=0;i<n;i++) {
			bw.write(arr[i]);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}

class Point {
	int x,y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}