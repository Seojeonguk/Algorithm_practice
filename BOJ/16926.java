import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,m,r;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) arr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		int min = Math.min(n, m)/2;
		for(int i=0; i < min ;i++) {
			int chk = (n-2*i)*2 + (m-2*i)*2-4;
			int tmp = r % chk;
			int up = i;
			int down = n-1-i;
			int left = i;
			int right = m-1-i;
			
			for(int recur=0;recur<tmp;recur++) {
				int temp = arr[up][left];
				
				for(int j=left;j<right;j++) arr[up][j] = arr[up][j+1];
				for(int j=up;j<down;j++) arr[j][right] = arr[j+1][right];
				for(int j=right;j>left;j--) arr[down][j] = arr[down][j-1];
				for(int j=down;j>up;j--) arr[j][left] = arr[j-1][left];
				
				arr[up+1][left] = temp;
			}
		}
		
		print();

		bw.flush();
		bw.close();
	}
	
	public static void print() throws Exception {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				bw.write(String.valueOf(arr[i][j]) + " ");
			}
			bw.newLine();
		}
		bw.newLine();
	}
}