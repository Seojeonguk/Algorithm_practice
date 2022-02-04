import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,l,ans,now,cnt;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		
		l = Integer.valueOf(st.nextToken());

		while(true) {
			if(solve(++now)) {
				cnt++;
			}
			if(cnt==n) break;
		}
			
		bw.write(String.valueOf(now));


		bw.flush();
		bw.close();
	}
	
	public static boolean solve(int x) {
		while(x!=0) {
			if(x%10==l) return false;
			x /= 10;
		}
		
		return true;
	}
}