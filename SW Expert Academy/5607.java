import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t;
	static int n,r;
	static long mod = 1234567891;
	static long[] fact;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			fact = new long[n+1];
			fact[0] = 1;
			for(int i=1;i<=n;i++)
				fact[i] = (fact[i-1]*i)%mod;
			
			long a = (fact[r] * fact[n-r])%mod;
			long a_p = a_p_calc(a,mod-2);
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf((fact[n] * a_p)%mod) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static long a_p_calc(long a,long power) {
		if(power==0) return 1;
		long temp = a_p_calc(a,power/2);
		long ret = (temp*temp)%mod;
		if(power%2!=0) ret = (ret*a)%mod;
		return ret;
	}
}