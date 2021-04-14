import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int t,cnt,n,m,ans;
	static int[][] map;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			
			ans = Integer.MAX_VALUE;
			map = new int[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			solve(map,0);
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(ans) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void solve(int[][] solvemap,int call_cnt) {
		if(call_cnt==cnt) {
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(solvemap[i][j] !=0 ) {
						sum++;
					}
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=0;i<m;i++) {
			int[][] copymap = new int[n][m];
			
			for(int q=0;q<n;q++)
				for(int w=0;w<m;w++)
					copymap[q][w] = solvemap[q][w];
			
			for(int j=0;j<n;j++)
				if(copymap[j][i] !=0 ) {
					delete(copymap,j,i);
					break;
				}
			
			for(int q=0;q<m;q++) {
				int w = 1;
				while(w<n) {
					if(copymap[w][q] == 0 && copymap[w-1][q]!=0) {
						copymap[w][q] = copymap[w-1][q];
						copymap[w-1][q]=0;
						w--;
						if(w==0) 
							w=1;
					} else {
						w++;
					}
				}
			}
			solve(copymap,call_cnt+1);
		}
	}
	public static void delete(int[][] solvemap,int x,int y) {
		int temp = solvemap[x][y];
		if(temp==0) return;
		solvemap[x][y] = 0;
		for(int i=0;i<4;i++) {
			for(int j=1;j<temp;j++) {
				int nx = x+X[i]*j;
				int ny = y+Y[i]*j;
				if(nx<0 || ny<0 || nx>n-1 || ny>m-1) continue;
				delete(solvemap,nx,ny);
			}
		}
	}
}