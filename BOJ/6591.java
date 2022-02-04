import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t;
	static int n,k;

	public static void main(String[] args) throws Exception {
		while(true) {
			st = new StringTokenizer(br.readLine());
	
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			
			k = Math.min(k, n-k);
			long div = 1;
			long ans = 1;
			while(k-- > 0) {
				ans *= n--;
				ans /= div++;
			}
			sb.append(ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}