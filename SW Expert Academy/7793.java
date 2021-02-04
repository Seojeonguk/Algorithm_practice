import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int n,m;
	static char[][] arr;
	static int sx,sy,dx,dy;
	static int X[]= {1,0,-1,0},Y[]= {0,1,0,-1};
	static Queue<Data> q;
	static boolean safe;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int test_case=1 ;test_case<=t;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			
			arr = new char[n][m];
			q = new LinkedList<Data>();
			safe = false;
			visit = new boolean[n][m];
			
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine().toCharArray();
				for(int j=0;j<m;j++) {
					if(arr[i][j] == 'D') {
						dx = i;
						dy = j;
					}
					if(arr[i][j] == 'S') {
						sx = i;
						sy = j;
						arr[i][j] = '.';
					}
					if(arr[i][j] == '*') {
						q.add(new Data(i,j,-1));
					}
				}
			}
			q.add(new Data(sx,sy,0));
			visit[sx][sy] = true;
			
			bw.write("#" + String.valueOf(test_case) + " ");
			
			while(!q.isEmpty()) {
				Data outdata = q.poll();
				
				if(outdata.cnt!=-1 && outdata.x == dx && outdata.y == dy) {
					bw.write(String.valueOf(outdata.cnt));
					safe = true;
					break;
				}
				
				
				for(int i=0;i<4;i++) {
					Data indata = new Data(outdata);
					
					indata.x += X[i];
					indata.y += Y[i];
					if(indata.cnt!=-1) indata.cnt++;
					
					
					
					if(indata.x<0 || indata.y<0 || indata.x > n-1 || indata.y>m-1 || arr[indata.x][indata.y]=='X') continue;
					if(indata.cnt == -1) {
						if(arr[indata.x][indata.y]=='.') {
							arr[indata.x][indata.y]= '*';
							q.add(indata);
						}
					}
					else {
						if(arr[indata.x][indata.y]== '.' || arr[indata.x][indata.y]== 'D' ) {
							if(!visit[indata.x][indata.y]) {
								visit[indata.x][indata.y]=true; 
								q.add(indata);
							}
						}
					}
				}
				
			}
			
			if(!safe) bw.write("GAME OVER");
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}

class Data {
	int x,y,cnt;
	
	public Data(int x,int y,int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	public Data(Data data) {
		this.x = data.x;
		this.y = data.y;
		this.cnt = data.cnt;
	}
}