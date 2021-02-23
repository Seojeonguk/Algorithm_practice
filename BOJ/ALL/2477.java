import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int k,h,w,sq;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		arr = new int[6][2];
		k = Integer.valueOf(br.readLine());
		
		for(int i=0;i<6;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
			if(arr[i][0]==1 || arr[i][0]==2) w = Math.max(w, arr[i][1]);
			else h = Math.max(h, arr[i][1]);
		}
		
		sq = w*h;
		
		for(int i=0;i<6;i++) {
			int dir = arr[i][0];
			int ndir = arr[(i+1)%6][0];
			
			if((dir==1 && ndir==3) || (dir==2 && ndir==4) || (dir==3&&ndir==2) || (dir==4 && ndir==1)) 
				sq -= arr[i][1] * arr[(i+1)%6][1];
		}
		
		System.out.println(sq*k);
		
		bw.flush();
		bw.close();
	}
}