import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t;
	static long a,b;
	static HashMap<Long, Long> m = new HashMap<Long, Long>(); 
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			
			long calc_a = f(a-1);
			long calc_b = f(b);
				
			sb.append("#" + tc + " " + (calc_b - calc_a) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static long f(long x) {
		if(m.containsKey(x)) return m.get(x);
		if(x<=9) return (x*(x+1))/2;
		long v=1;
		while(true) {
			if(v*10 > x) break;
			v*=10;
		}
		long ret=f(x-1-x%v) + g(x);
		
		m.put(x, ret);
		return ret;
	}
	
	public static long g(long x) {
		
		long v = 1;
		while(true) {
			if(v*10>x) break;
			v*=10;
		}
		long ret = x/v*(x%v+1)+f(x%v);
		
		return ret;
	}
}