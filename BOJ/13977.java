import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int m,n,k;
	static long mod = 1000000007;
	static long[] fact;
	static int MAX_N = 4000000;

	public static void main(String[] args) throws Exception {
		fact = new long[MAX_N+1];
		fact[0] = 1;
		for(int i=1;i<=MAX_N;i++)
			fact[i] = (fact[i-1]*i)%mod;
		
		m = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=m; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			
			long a = (fact[k] * fact[n-k])%mod;
			long a_p = a_p_calc(a,mod-2);
			
			sb.append((fact[n] * a_p)%mod + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long a_p_calc(long a,long power) {
		if(power==0) return 1;
		long temp = a_p_calc(a,power/2);
		long ret = (temp*temp)%mod;
		if(power%2!=0) ret = (ret*a)%mod;
		return ret;
	}
}