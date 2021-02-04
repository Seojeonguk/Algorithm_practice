import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,now;
	static int a,b,ans;
	static int[][] arr;
	static boolean[][] visit;
	static int X[]= {1,0,-1,0,-1,1},Y[]= {0,1,0,-1,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[145][145];
		visit = new boolean[145][145];
		for(int i=1;now!=10000;i++) {
			for(int j=1;j<=i && now!=10000;j++) {
				arr[i][j] = ++now;
			}
		}
		
		t = Integer.valueOf(br.readLine());
		for(int test_case=1 ;test_case<=t;test_case++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());

			for(int i=1;i<=141;i++) {
				Arrays.fill(visit[i], false);
			}
			
			for(int i=1;i<=141;i++) {
				for(int j=1;j<=i;j++) {
					if(a==arr[i][j]) {
						solve(i,j);
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n",test_case,ans);
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int x,int y) {
		Queue<data> q = new LinkedList<data>();
		q.add(new data(x,y,0));
		
		while(!q.isEmpty()) {
			data outdata = q.poll();
			
			if(arr[outdata.x][outdata.y]== b ) {
				ans = outdata.cnt;
				return;
			}
			
			for(int i=0;i<6;i++) {
				data indata = new data(outdata);
				indata.x += X[i];
				indata.y += Y[i];
				indata.cnt += 1;
				if(arr[indata.x][indata.y]!=0 && !visit[indata.x][indata.y]) {
					visit[indata.x][indata.y]= true;
					q.add(indata);
				}
			}
		}
	}
}

class data {
	int x,y,cnt;
	
	data(int x,int y,int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	data(data a) {
		x = a.x;
		y = a.y;
		cnt = a.cnt;
	}
}