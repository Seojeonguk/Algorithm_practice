import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t;
	static int n,r;
	static long mod = 1000000007;
	static long[] fact;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		fact = new long[n+1];
		fact[0] = 1;
		for(int i=1;i<=n;i++)
			fact[i] = (fact[i-1]*i)%mod;

		long a = (fact[r] * fact[n-r])%mod;
		long a_p = a_p_calc(a,mod-2);

		sb.append((fact[n] * a_p)%mod);
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