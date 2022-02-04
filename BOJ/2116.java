import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,ans;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		arr = new int[n][6];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++)
				arr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		int bottom=0,top=0;
		for(int start_bottom=0;start_bottom<6;start_bottom++) {
			int sum=0;
			
			bottom = start_bottom;
			top = find_top(bottom);
			sum = find_max(0,bottom,top);
			for(int i=1;i<n;i++) {
				for(int j=0;j<6;j++) {
					if(arr[i-1][top] == arr[i][j]) {
						bottom = j;
						top = find_top(bottom);
						break;
					}
				}
				sum += find_max(i,bottom,top);
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
		

		bw.flush();
		bw.close();
	}
	
	public static int find_top(int idx) {
		if(idx==0) return 5;
		else if(idx==1) return 3;
		else if(idx==2) return 4;
		else if(idx==3) return 1;
		else if(idx==4) return 2;
		else return 0;
	}
	
	public static int find_max(int n,int bottom,int top) {
		int ret=0;
		for(int i=0;i<6;i++) {
			if(i==bottom || i==top) continue;
			ret = Math.max(ret, arr[n][i]);
		}
		return ret;
	}
}