import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class fish{
		int x,y,d,num;
		boolean live;
		
		public fish(int x, int y, int d, int num, boolean live) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.num = num;
			this.live = live;
		}
		
		public fish(fish o) {
			this.x = o.x;
			this.y = o.y;
			this.d = o.d;
			this.num = o.num;
			this.live = o.live;
		}
	}
	
	static int ans;
	static int[] X= {-1,-1,0,1,1,1,0,-1}, Y= {0,-1,-1,-1,0,1,1,1};
	
	public static void main(String[] args) throws Exception {
		fish[][] map = new fish[4][4];
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int fish_num = Integer.parseInt(st.nextToken());
				int fish_dir = Integer.parseInt(st.nextToken());
				map[i][j] = new fish(i,j,fish_dir-1,fish_num,true);
			}
		}
		fish shark = new fish(0,0,map[0][0].d,0,false);
		map[0][0].live = false;
		solve(shark,map[0][0].num,map,0);
		System.out.println(ans);
	}
	
	public static void solve(fish shark,int score,fish[][] map,int idx) {
		ans = Math.max(ans, score);
		
		fish[][] tmap = new fish[4][4];
		for(int i=0;i<4;i++) 
			for(int j=0;j<4;j++)
				tmap[i][j] = new fish(map[i][j]);
				
		
		for(int num=1;num<=16;num++) {
			outerLoop : for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(tmap[i][j].num == num && tmap[i][j].live) {
						for(int d=0;d<8;d++) {
							int dir = (tmap[i][j].d + d) % 8;
							int nx = tmap[i][j].x + X[dir];
							int ny = tmap[i][j].y + Y[dir];
							if(isout(nx,ny) || (shark.x == nx && shark.y == ny)) continue;
							if(!tmap[nx][ny].live) {
								tmap[i][j].live = false;
								tmap[nx][ny].num = tmap[i][j].num;
								tmap[nx][ny].d = dir;
								tmap[nx][ny].live = true;
							} else {
								int tmp_num = tmap[nx][ny].num;
								int tmp_dir = tmap[nx][ny].d;
								
								tmap[nx][ny].num = tmap[i][j].num;
								tmap[nx][ny].d = dir;
								
								tmap[i][j].num = tmp_num;
								tmap[i][j].d = tmp_dir;
							}
							break outerLoop;
						}
					}
				}
			}
		}
		
		for(int i=1;i<4;i++) {
			int nx = shark.x + X[shark.d] * i;
			int ny = shark.y + Y[shark.d] * i;
			if(isout(nx,ny) || !tmap[nx][ny].live) continue;
			tmap[nx][ny].live = false;
			solve(new fish(nx,ny,tmap[nx][ny].d,0,false),score+tmap[nx][ny].num,tmap,idx+1);
			tmap[nx][ny].live = true;
		}
	}
	
	public static boolean isout(int x,int y) {
		return x<0 || y<0 || x>3 || y>3;
	}
}