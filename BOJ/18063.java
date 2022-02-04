import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,c,sum;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		
		for(int i=0;i<n;i++) {
			arr = br.readLine().toCharArray();
			int mm = (arr[0]-'0') * 60;
			int ss = (arr[2] -'0') * 10 + (arr[3]-'0');
			sum+= mm+ss;
		}
		
		sum -= (n-1)*c;
		
		System.out.printf("%02d:%02d:%02d\n",sum/3600,sum/60%60,sum%60);

		bw.flush();
		bw.close();
	}
}