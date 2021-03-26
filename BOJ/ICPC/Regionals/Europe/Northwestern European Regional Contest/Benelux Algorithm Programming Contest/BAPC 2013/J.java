import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,m;
	static char[][] a;
	static int[][][] d;
	static Deque<Integer> start,dq;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		while(t-- > 0 ) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			a = new char[n+2][m+2];
			d = new int[n+2][m+2][3];
			start = new ArrayDeque<Integer>();
			
			for(int i=0;i<=n+1;i++) {
				Arrays.fill(a[i], '.');
				for(int j=0;j<=m+1;j++)
					Arrays.fill(d[i][j], -1);
			}
			
			for(int i=0;i<=n+1;i++) {
				for(int j=0;j<=m+1;j++)
					for(int k=0;k<3;k++)
						if(d[i][j][k] !=-1) System.out.println("hi");
			}
			
			for(int i=1;i<=n;i++) {
				String str = br.readLine();
				for(int j=1;j<=m;j++) {
					a[i][j] = str.charAt(j-1);
					if(a[i][j] == '$') {
						a[i][j]='.';
						start.addLast(i*1000+j);
					}
				}
			}
			System.out.println(solve());
		}
		
	}
	
	public static int solve() {
		int ret = Integer.MAX_VALUE;
		start.addLast(0);
		
		for(int i=0;i<3;i++) {
			int xy = start.poll();
			dq = new ArrayDeque<Integer>();
			dq.addLast(xy);
			d[xy/1000][xy%1000][i] = 0;
			
			while(!dq.isEmpty()) {
				int outdata = dq.pollFirst();
				for(int dir=0;dir<4;dir++) {
					int nx = outdata/1000 + X[dir];
					int ny = outdata%1000 + Y[dir];
					if(nx<0 || ny<0 || nx>n+1 || ny>m+1 || d[nx][ny][i] >= 0 || a[nx][ny]=='*') continue;
					if(a[nx][ny]=='.') {
						d[nx][ny][i] = d[outdata/1000][outdata%1000][i];
						dq.addFirst(nx*1000+ny);
					} else if(a[nx][ny]=='#') {
						d[nx][ny][i] = d[outdata/1000][outdata%1000][i]+1;
						dq.addLast(nx*1000+ny);
					}
				}
			}
		}
		
		for(int i = 0; i <= n+1; i++){
	        for(int j = 0; j <= m+1; j++){
	            if(a[i][j] == '*') continue;
	            int sum = d[i][j][0] + d[i][j][1] + d[i][j][2];
	            if(a[i][j] == '#') sum -= 2;
	            
	            if(sum>=0) ret = Math.min(ret, sum);
	        }
	    }
		
		return ret;
	}
}