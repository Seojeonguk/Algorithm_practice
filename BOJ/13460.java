import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m;
	static char[][] board;
	static int X[]= {1,0,-1,0},Y[]= {0,1,0,-1};
	static int rx,ry,bx,by;
	static boolean[][][][] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		board = new char[n][m];
		visit = new boolean[n][m][n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'B') {bx = i;by = j;}
				else if(board[i][j] == 'R') {rx = i;ry = j;}
			}
		}
		
		
		System.out.println(solve());

		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		Queue<rb> q = new LinkedList<rb>();
		q.add(new rb(rx,ry,bx,by,0));
		visit[rx][ry][bx][by] = true;
		
		while(!q.isEmpty()) {
			rb outdata = q.poll();
			
			if(board[outdata.rx][outdata.ry]=='O') 
				return outdata.cnt;
			
			if(outdata.cnt==10) continue;
			
			for(int i=0;i<4;i++) {
				int nrx = outdata.rx;
				int nry = outdata.ry;
				int nbx = outdata.bx;
				int nby = outdata.by;
				
				while(board[nbx+X[i]][nby+Y[i]]!='#') {
					if(board[nbx][nby]=='O') break;
					nbx+=X[i];
					nby+=Y[i];
				}
				
				if(board[nbx][nby]=='O') continue;
				
				
				while(board[nrx+X[i]][nry+Y[i]]!='#') {
					if(board[nrx][nry]=='O') break;
					nrx+=X[i];
					nry+=Y[i];
				}
				
				if (nbx == nrx && nby == nry) {
					if (outdata.bx == outdata.rx) {
						if (i == 1) {
							if (outdata.by > outdata.ry) nry -= Y[i];
							else nby -= Y[i];
						}
						else {
							if (outdata.by > outdata.ry) nby -= Y[i];
							else nry -= Y[i];
						}
					}
					else {
						if (i == 0) {
							if (outdata.bx > outdata.rx) nrx -= X[i];
							else nbx -= X[i];
						}
						else {
							if (outdata.bx > outdata.rx) nbx -= X[i];
							else nrx -= X[i];
						}
					}
				}
				
				if(visit[nrx][nry][nbx][nby]) continue;
				visit[nrx][nry][nbx][nby] = true;
				q.add(new rb(nrx,nry,nbx,nby,outdata.cnt+1));
			}
		}
		
		
		
		return -1;
	}
}


class rb {
	int rx,ry,bx,by,cnt;
	public rb(int rx,int ry,int bx,int by,int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}