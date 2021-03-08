import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,d;
	static int[][] map,cpmap;
	static xy[] archer,delete;
	static int ans;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		d = Integer.valueOf(st.nextToken());
		map = new int[n][m];
		cpmap = new int[n][m];
		archer = new xy[3];
		delete = new xy[3];
		for(int i=0;i<3;i++) {
			archer[i] = new xy();
			delete[i] = new xy();
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				map[i][j] = Integer.valueOf(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			for(int j=i+1;j<m;j++) {
				for(int k=j+1;k<m;k++) {
					archer[0].x = archer[1].x = archer[2].x = n;
					archer[0].y = i;
					archer[1].y = j;
					archer[2].y = k;
					solve();
				}
			}
		}
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
	}
	
	public static void solve() {
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				cpmap[i][j] = map[i][j];
		
		int kill_cnt=0;
		
		for(int dd=0;dd<n;dd++) {
			for(int k=0;k<3;k++) {
				int dis = Integer.MAX_VALUE;
				int x = Integer.MAX_VALUE;
				int y = Integer.MAX_VALUE;
				for(int i=0;i<n-dd;i++) {
					for(int j=0;j<m;j++) {
						if(cpmap[i][j]==1) {
							int distance = Math.abs(archer[k].x - i) + Math.abs(archer[k].y - j);
							if(dis > distance) {
								dis = distance;
								x = i;
								y = j;
							} else if(dis==distance) {
								if(y>j) {
									x = i;
									y = j;
								}
							}
						}
					}
				}
				
				
				delete[k].x = x;
				delete[k].y = y;
				delete[k].d = dis;
			}
			
			for(int i=0;i<3;i++) {
				if(delete[i].d <= d+dd && cpmap[delete[i].x][delete[i].y]==1) {
					cpmap[delete[i].x][delete[i].y]=0;
					kill_cnt++;
				}
			}
		}
		
		
		ans = Math.max(ans, kill_cnt);
	}
}

class xy{
	int x, y, d;
	public xy() {
	}
	
	public xy(int x,int y,int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}