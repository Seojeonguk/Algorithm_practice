import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n;
	static boolean able;
	static char[][] arr;
	static int X[]= {1,-1,0,0,-1,1,-1,1},Y[]= {0,0,1,-1,-1,1,1,-1};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			arr = new char[n][n];
			able = false;
			for(int i=0;i<n;i++) arr[i] = br.readLine().toCharArray();
			
			outerloop:for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]=='o') {
						for(int k=0;k<8;k+=2) {
							int cnt=0,cnt2=0;
							int nx = i,ny=j;
							int nnx =i,nny=j;
							while(true) {
								nx+=X[k];
								ny+=Y[k];
								if(!range(nx,ny) || arr[nx][ny]!=arr[i][j]) break;
								cnt++;
							}
							
							while(true) {
								nnx += X[k+1];
								nny += Y[k+1];
								if(!range(nnx,nny) || arr[nnx][nny]!=arr[i][j]) break;
								cnt2++;
							}
							if(cnt+cnt2+1 >= 5) {
								able = true;
								break outerloop;
							}
						}
					}
				}
			}
			
			bw.write("#" + String.valueOf(test_case) + " " + (able ? "YES" : "NO") + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static boolean range(int x,int y) {
		if(x>=0 && y>=0 && x<n && y<n) return true;
		return false;
	}
}