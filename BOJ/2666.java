import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,l,r,k;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		l = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(br.readLine());
		
		
		arr = new int[k];
		for(int i=0;i<k;i++)
			arr[i] = Integer.valueOf(br.readLine());
		
		System.out.println(solve(0,l,r));

		bw.flush();
		bw.close();
	}
	
	public static int solve(int cnt,int left,int right) {
		if(cnt==k) return 0;
		int left_move = solve(cnt+1,arr[cnt],right) + Math.abs(arr[cnt]-left);
		int right_move = solve(cnt+1,left,arr[cnt]) + Math.abs(arr[cnt]-right);
		
		return Math.min(left_move,right_move);
	}
}