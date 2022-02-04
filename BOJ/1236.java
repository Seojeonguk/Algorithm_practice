import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n,m;
	static char[][] arr;
	static boolean[] s,g;
	static int cnt1,cnt2;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		arr = new char[n][m];
		s = new boolean[n];
		g = new boolean[m];
		cnt1 = n;
		cnt2 = m;
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='X') {
					if(!s[i]) {
						s[i] = true;
						cnt1--;
					}
					if(!g[j]) {
						g[j]= true;
						cnt2--;
					}
				}
			}
		}
		
		System.out.println(Math.max(cnt1, cnt2));
		
		bw.flush();
		bw.close();
	}
}