import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.valueOf(st.nextToken());
			if(i!=0) {
				ans = Math.min(ans, Math.abs(arr[i]-arr[i-1]));
			}
		}
		
		
		
		bw.write(String.valueOf(ans));

		bw.flush();
		bw.close();
	}
}