import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n,m,b,height,ans=Integer.MAX_VALUE;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int high=0;high<=256;high++) {
			int add=0,delete=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] > high) delete += Math.abs(high-map[i][j]);
					else if(map[i][j] < high) add += Math.abs(high-map[i][j]);
				}
			}
			
			if(delete + b < add) continue;
			int time = 2*delete + add;
			if(time<=ans) {
				ans = time;
				height = high;
			}
		}
		System.out.println(ans + " " + height);
	}
}