import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m,r;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<r;i++) {
			int idx = Integer.parseInt(st.nextToken());
			if(idx==1) solve1();
			else if(idx==2) solve2();
			else if(idx==3) solve3();
			else if(idx==4) solve4();
			else if(idx==5) solve5();
			else if(idx==6) solve6();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve1() {
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n-i-1][j];
				arr[n-i-1][j] = temp;
			}
		}
	}
	
	public static void solve2() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][m-j-1];
				arr[i][m-j-1] = temp;
			}
		}
	}
	
	public static void solve3() {
		int tmp = n;
		n =m ;
		m = tmp;
		int[][] temp = new int[n][m];
		
		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++)
				temp[i][j] = arr[m-1-j][i];
		
		arr = temp;
	}
	
	public static void solve4() {
		int tmp = n;
		n = m;
		m = tmp;
		int[][] temp = new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				temp[i][j] = arr[j][n-1-i];
		
		arr = temp;
	}
	
	public static void solve5() {
		int[][] temp = new int[n][m];
		
		for(int i=0;i<n/2;i++)
			for(int j=0;j<m/2;j++)
				temp[i][j] = arr[i+n/2][j];
		
		for(int i=0;i<n/2;i++)
			for(int j=m/2;j<m;j++)
				temp[i][j] = arr[i][j-m/2];
		
		for(int i=n/2;i<n;i++)
			for(int j=0;j<m/2;j++)
				temp[i][j] = arr[i][j+m/2];
		
		for(int i=n/2;i<n;i++)
			for(int j=m/2;j<m;j++)
				temp[i][j] = arr[i-n/2][j];
		
		arr = temp;
	}
	
	public static void solve6() {
		int[][] temp = new int[n][m];
		
		for(int i=0;i<n/2;i++)
			for(int j=0;j<m/2;j++)
				temp[i][j] = arr[i][j+m/2];
		
		for(int i=0;i<n/2;i++)
			for(int j=m/2;j<m;j++)
				temp[i][j] = arr[i+n/2][j];
		
		for(int i=n/2;i<n;i++)
			for(int j=0;j<m/2;j++)
				temp[i][j] = arr[i-n/2][j];
		
		for(int i=n/2;i<n;i++)
			for(int j=m/2;j<m;j++)
				temp[i][j] = arr[i][j-m/2];
		
		arr = temp;
	}
}