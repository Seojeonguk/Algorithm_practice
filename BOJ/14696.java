import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t;
	static int a,b;
	static int input;
	static int[] arr,brr;

	public static void main(String[] args) throws Exception {
		t = Integer.valueOf(br.readLine());

		while(t-->0) {
			arr = new int[5];
			brr = new int[5];
			st = new StringTokenizer(br.readLine());
			a = Integer.valueOf(st.nextToken());
			for(int i=0;i<a;i++)
				arr[Integer.valueOf(st.nextToken())]++;

			st = new StringTokenizer(br.readLine());
			b = Integer.valueOf(st.nextToken());
			for(int i=0;i<b;i++) 
				brr[Integer.valueOf(st.nextToken())]++;

			int whoswin=0;
			if(arr[4] < brr[4]) whoswin = 2;
			else if(arr[4]>brr[4]) whoswin=1;
			else {
				if(arr[3] < brr[3]) whoswin=2;
				else if(arr[3] > brr[3]) whoswin=1;
				else {
					if(arr[2] < brr[2]) whoswin=2;
					else if(arr[2] > brr[2]) whoswin=1;
					else {
						if(arr[1] < brr[1]) whoswin = 2;
						else if(arr[1]>brr[1]) whoswin=1;
					}
				}
			}

			if(whoswin==0) bw.write("D");
			else if(whoswin==1) bw.write("A");
			else if(whoswin==2) bw.write("B");
			bw.newLine();
		}


		bw.flush();
		bw.close();
	}
}