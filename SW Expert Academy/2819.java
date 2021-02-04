import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static char[][] arr;
	static Set<String> set;
	static int X[]= {0,1,0,-1},Y[]= {1,0,-1,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int test_case=1 ;test_case<=t;test_case++) {
			arr = new char[4][4];
			set = new HashSet<String>();
			
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) 
					arr[i][j] = st.nextToken().charAt(0);
			}
			
			for(int i=0;i<4;i++) 
				for(int j=0;j<4;j++) 
					solve(i,j,String.valueOf(arr[i][j]));
			
			System.out.printf("#%d %d\n",test_case,set.size());
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int x,int y,String s) {
		if(s.length()==7) {
			set.add(s);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x + X[i];
			int ny = y + Y[i];
			if(nx<0 || ny<0 || nx>3 || ny>3) continue;
			solve(nx,ny,s+String.valueOf(arr[nx][ny]));
		}
	}
}