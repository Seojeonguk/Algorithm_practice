import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,prev,now,in_cnt,de_cnt,ans;

	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			prev = now;
			now = Integer.valueOf(st.nextToken());
			
			if(prev<=now) in_cnt++;
			else in_cnt=1;
			
			if(prev>=now) de_cnt++;
			else de_cnt=1;
			
			ans = Math.max(ans, Math.max(in_cnt, de_cnt));
		}
		
		bw.write(String.valueOf(ans));

		bw.flush();
		bw.close();
	}
}