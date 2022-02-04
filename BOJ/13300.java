import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,k,s,y,ans;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		arr = new int[7][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.valueOf(st.nextToken());
			y = Integer.valueOf(st.nextToken());
			arr[y][s]++;
		}
		
		for(int i=1;i<=6;i++)
			for(int j=0;j<=1;j++) 
				ans += arr[i][j]/k + (arr[i][j]%k!=0?1:0);
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
	}
}