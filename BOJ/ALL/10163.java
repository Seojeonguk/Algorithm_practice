import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int MAX=1001;
	static int n;
	static int[][] plane;
	static int[] ans;
	static int x,y,width,height;
	

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		plane = new int[MAX][MAX];
		for(int i=0;i<MAX;i++) {
			Arrays.fill(plane[i], n);
		}
		ans = new int[n+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			for(int paper_x = x; paper_x < x+ width; paper_x++ ) {
				for(int paper_y = y; paper_y < y+height; paper_y++) {
					ans[plane[paper_x][paper_y]]--;
					plane[paper_x][paper_y] = i;
					ans[plane[paper_x][paper_y]]++;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			sb.append(ans[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}