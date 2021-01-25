import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		Arrays.fill(dp, 1000003);

		bw.write(String.valueOf(solve(n)));
		
		bw.flush();
		bw.close();
	}
	
	public static int solve(int x) {
		if(x==1) return 0;
		int ret = dp[x];
		if(ret!=1000003) return ret;
		
		if(x%3==0) ret = Math.min(ret, solve(x/3)+1);
		if(x%2==0) ret = Math.min(ret, solve(x/2)+1);
		ret = Math.min(ret, solve(x-1)+1);
		
		return dp[x] = ret;
	}
}