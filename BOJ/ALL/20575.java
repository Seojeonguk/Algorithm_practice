import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n,cnt;
	static double[] arr;
	
	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		arr = new double[4];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				arr[j] = Double.valueOf(st.nextToken());
			}
			
			int ax = (int)Math.floor(arr[0]);
			int bx = (int)Math.floor(arr[2]);
			if(ax!=bx) cnt++;
		}
		System.out.println((double)(2.0*n/cnt));
		
		bw.flush();
		bw.close();
	}
}