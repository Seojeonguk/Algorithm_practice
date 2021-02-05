import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n;
	static int X[]= {1,0,-1,0},Y[]= {0,1,0,-1};
	static int[][] arr;
	static int ans,ans_cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		t = Integer.valueOf(br.readLine());
		for(int test_case=1 ;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			
			arr = new int[n][n];
			ans_cnt=0;
			ans = Integer.MAX_VALUE;
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
					arr[i][j] = Integer.valueOf(st.nextToken());
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					solve(i,j,1,arr[i][j]);
				}
			}
			
			System.out.printf("#%d %d %d\n",test_case,ans,ans_cnt);
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int x,int y,int cnt,int start) {
		if(cnt>=ans_cnt) {
			if(cnt==ans_cnt) ans = Math.min(ans, start);
			else ans = start;
			ans_cnt = cnt;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+X[i];
			int ny = y+Y[i];
			
			if(nx<0 || ny<0|| nx>n-1 || ny>n-1 || arr[nx][ny] != start+cnt) continue;
			solve(nx,ny,cnt+1,start);
		}
	}
}