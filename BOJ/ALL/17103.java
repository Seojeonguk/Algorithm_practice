import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n;
	static int MAX=1000002;
	static boolean[] chk;
	
	
	public static void main(String[] args) throws Exception {
		chk = new boolean[MAX];
		for(int i=2;i<MAX;i++) {
			if(!chk[i]) {
				for(int j=i+i;j<MAX;j+=i)
					chk[j] = true;
			}
		}
		
		t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			int ans=0;
			for(int i=2;i<=n/2;i++) 
				if(!chk[i] && !chk[n-i]) 
					ans++;
			System.out.println(ans);
		}
	}
}