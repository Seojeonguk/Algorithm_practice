import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int n;
	static int arr[],brr[];
	static int max=-1000000001,min=1000000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(br.readLine());
		arr = new int[n];
		brr = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) 
			arr[i] = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			brr[i] = Integer.valueOf(st.nextToken());
		
		solve(1,arr[0]);
		
		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(min));
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,int sum) {
		if(idx==n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if(brr[0]!=0) {
			brr[0]--;
			solve(idx+1,sum+arr[idx]);
			brr[0]++;
		}
		if(brr[1]!=0) {
			brr[1]--;
			solve(idx+1,sum-arr[idx]);
			brr[1]++;
		}
		if(brr[2]!=0) {
			brr[2]--;
			solve(idx+1,sum*arr[idx]);
			brr[2]++;
		}
		if(brr[3]!=0) {
			brr[3]--;
			solve(idx+1,sum/arr[idx]);
			brr[3]++;
		}
	}
}