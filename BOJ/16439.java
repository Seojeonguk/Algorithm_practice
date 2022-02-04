import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,ans;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			for(int j=i+1;j<m;j++) {
				for(int k=j+1;k<m;k++) {
					int sum=0;
					for(int a=0;a<n;a++) 
						sum += Math.max(arr[a][i], Math.max(arr[a][j], arr[a][k]));
					ans = Math.max(ans, sum);
				}
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}