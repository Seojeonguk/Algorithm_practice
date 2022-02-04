import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] arr;
	static int[] have;
	static int cnt,ans;
	static boolean find;
	

	public static void main(String[] args) throws Exception {
		arr = new int[10][10];
		have = new int[6];
		ans = Integer.MAX_VALUE;
		
		for(int i=1;i<=5;i++)
			have[i] = 5;
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j] == 1) cnt++;
			}
		}
		
		solve(cnt);

		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int count) {
		if(count==0) {
			int sum=0;
			for(int i=1;i<=5;i++) 
				sum+= (5-have[i]);
			if(sum>=0) ans = Math.min(ans, sum);
			return;
		}
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(arr[i][j]==1) {
					for(int k=5;k>=1;k--) {
						if(have[k]>0 && ischk(i,j,k)) {
							visit(i,j,k,0);
							have[k]--;
							solve(count-k*k);
							have[k]++;
							visit(i,j,k,1);
						}
					}
					return;
				}
			}
		}
	}
	
	public static boolean ischk(int x,int y,int k) {
		for(int i=x;i<x+k;i++) {
			for(int j=y;j<y+k;j++) {
				if(!range(i,j) || arr[i][j]==0)
					return false;
			}
		}
		return true;
	}
	
	public static boolean range(int x,int y) {
		if( x>=0 && y>=0&& x<=9 && y<=9) return true;
		return false;
	}
	
	public static void visit(int x,int y,int k,int c) {
		for(int i=x;i<x+k;i++) {
			for(int j=y;j<y+k;j++) {
				if(range(i,j)) {
					arr[i][j] = c;
				}
			}
		}
	}
}