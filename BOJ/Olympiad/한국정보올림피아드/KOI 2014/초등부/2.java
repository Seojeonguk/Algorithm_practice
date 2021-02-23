import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n,a,b,c,d;
	static int[] ans;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		
		n = Integer.valueOf(br.readLine());
		
		arr = new int[102][102];
		ans = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			c = Integer.valueOf(st.nextToken());
			d = Integer.valueOf(st.nextToken());
			
			for(int j=a;j<a+c;j++)
				for(int k=b;k<b+d;k++) {
					ans[arr[j][k]]--;
					arr[j][k] = i;
					ans[i]++;
				}
		}
		
		for(int i=1;i<=n;i++)
			bw.write(String.valueOf(ans[i]+"\n"));
		
		bw.flush();
		bw.close();
	}
}