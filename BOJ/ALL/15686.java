import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m;
	static int[][] map;
	static List<xy> h = new LinkedList<xy>();
	static List<xy> c = new LinkedList<xy>();
	static xy[] xyxy;
	static int ans=Integer.MAX_VALUE;
	static int h_size,c_size;
	

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		map = new int[n][n];
		xyxy = new xy[m];
		
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			//st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(str[j]);
				//map[i][j] = Integer.valueOf(st.nextToken());
				if(map[i][j]==1) h.add(new xy(i,j));
				else if(map[i][j]==2) c.add(new xy(i,j));
			}
		}
		
		h_size = h.size();
		c_size = c.size();
		solve(0,0);
		
		System.out.println(ans);

		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,int cnt) {
		if(cnt==m) {
			int sum=0;
			for(int i=0;i<h_size;i++) {
				int d = Integer.MAX_VALUE;
				
				for(int j=0;j<m;j++) {
					int tmp = Math.abs(xyxy[j].x - h.get(i).x) + Math.abs(xyxy[j].y - h.get(i).y);
					d = Math.min(d, tmp);
				}
				sum+=d;
			}
			
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i=idx;i<c_size;i++) {
			xyxy[cnt] = c.get(i);
			solve(i+1,cnt+1);
		}
	}
}

class xy {
	int x,y;
	public xy(int x,int y) {
		this.x = x;
		this.y = y;
	}
}