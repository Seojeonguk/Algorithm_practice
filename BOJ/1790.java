import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,k,s,i,sum,a;
	static boolean chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		chk = true;
		a=s=1;
		
		for(i=1;i<=n;i++) {
			if(a*10 <= i) {
				a*=10;
				s++;
			}
			if(sum+s > k) {
				chk = false;
				break;
			}
			sum+=s;
		}
		
		if(sum==k) {
			i--;
			bw.write(String.valueOf(i%10));
		}
		else if(chk) {
			bw.write("-1");
		}
		else {
			s = solve(i);
			
			for(;sum!=k;sum++,s/=10);
			
			bw.write(String.valueOf((i/s)%10));
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int solve(int q) {
		int ret = 1;
		while (q!=0) {
			q /= 10;
			ret *= 10;
		}
		return ret;
	}
}