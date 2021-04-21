import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,ans,idx=1;
	static int[] high;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		high = new int[n+2];
		for(int i=1;i<=n+1;i++) {
			if(i!=n+1)
				high[i] = Integer.parseInt(st.nextToken());
			
			if(high[i] <= high[i-1]) {
				ans = Math.max(ans, high[i-1] - high[idx]);
				idx = i;
			} 
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}
} 