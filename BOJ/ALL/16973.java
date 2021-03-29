import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,h,w,sr,sc,fr,fc;
	static int[][] arr,sum;
	static int[] X = {1,0,-1,0}, Y = {0,1,0,-1};
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int nx,ny,ncnt;
	
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		sum = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (arr[i][j] == 0 ? 1 : 0);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		fr = Integer.parseInt(st.nextToken());
		fc = Integer.parseInt(st.nextToken());
		
		visit[sr][sc] = true;
		q.add(new int[] {sr,sc,0});
		
		int ans=-1;
		while(!q.isEmpty()) {
			int[] outdata = q.poll();
			
			if(outdata[0] == fr && outdata[1] == fc) {
				ans = outdata[2];
				break;
			}
			
			for(int i=0;i<4;i++) {
				nx = outdata[0] + X[i];
				ny = outdata[1] + Y[i];
				ncnt = outdata[2]+1;
				if(outrange(nx,ny) || outrange(nx+h-1,ny+w-1) || visit[nx][ny]) continue;
				if(sum[nx+h-1][ny+w-1] - sum[nx+h-1][ny-1] - sum[nx-1][ny+w-1] + sum[nx-1][ny-1] != h*w) continue;
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny,ncnt});
				
			}
		}
		System.out.println(ans);
	}
	
	public static boolean outrange(int x,int y) {
		return x<1 || y<1 || x>n || y>m;
	}
}