import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,ans;
	static int[] arr,brr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());

		arr = new int[n];
		brr = new int[n];
		ans = Integer.MAX_VALUE;

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.valueOf(st.nextToken());
			brr[i] = Integer.valueOf(st.nextToken());
		}

		solve(0,1,0);

		System.out.println(ans);

		bw.flush();
		bw.close();
	}

	public static void solve(int idx,int s,int ss) {
		if(idx==n) {
			if(ss!=0) ans = Math.min(ans, Math.abs(s-ss));
			return;
		}

		solve(idx+1,s * arr[idx],ss + brr[idx]);
		solve(idx+1,s,ss);
	}
}