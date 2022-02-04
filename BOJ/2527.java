import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] arr,brr;

	public static void main(String[] args) throws Exception {
		
		arr=new int[4];
		brr=new int[4];
		for(int tc=0;tc<4;tc++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) arr[i] = Integer.valueOf(st.nextToken());
			for(int i=0;i<4;i++) brr[i] = Integer.valueOf(st.nextToken());
			
			int left = Math.max(arr[0], brr[0]);
			int right = Math.min(arr[2], brr[2]);
			int top = Math.min(arr[3],brr[3]);
			int bottom = Math.max(arr[1], brr[1]);
			
			if(left < right && top > bottom) bw.write("a");
			else if(bottom==top && left==right) bw.write("c");
			else if(bottom == top || left==right) bw.write("b");
			else bw.write("d");
			bw.newLine();
			
		}


		bw.flush();
		bw.close();
	}
}